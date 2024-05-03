package com.hit.webhomework.service.impl;

import com.google.gson.Gson;
import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.enums.AppHttpCodeEnum;
import com.hit.webhomework.utils.PathUtils;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
@Data
@ConfigurationProperties(prefix = "oss")
public class OssUploadServiceImpl {
    private String accessKey;
    private String secretKey;
    private String bucket;
    private String testDomainName;

    public ResponseResult uploadImg(MultipartFile img) {
        //获取原始文件名
        String originalFilename = img.getOriginalFilename();
        //类型过滤
        if (!originalFilename.endsWith("png")) {
            throw new RuntimeException(AppHttpCodeEnum.FILE_TYPE_ERROR.getMsg());
//            return ResponseResult.error(AppHttpCodeEnum.FILE_TYPE_ERROR);
        }
        String filePath = PathUtils.generateFilePath(originalFilename);
        String url = uploadOss(img,filePath);
        return ResponseResult.ok(url);
        //前端拿着上传成功的url填充添加/修改商品的img项
    }

    public String uploadOss(MultipartFile img,String filePath) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.autoRegion());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
        //...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = filePath;

        try {

            InputStream inputStream = img.getInputStream();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);

            try {
                Response response = uploadManager.put(inputStream,key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

                return testDomainName + key;
            } catch (QiniuException ex) {
                ex.printStackTrace();
                if (ex.response != null) {
                    System.err.println(ex.response);

                    try {
                        String body = ex.response.toString();
                        System.err.println(body);
                    } catch (Exception ignored) {
                    }
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return "error";
    }
}
