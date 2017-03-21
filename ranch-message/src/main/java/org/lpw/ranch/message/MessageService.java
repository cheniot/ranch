package org.lpw.ranch.message;

import com.alibaba.fastjson.JSONObject;

/**
 * @author lpw
 */
public interface MessageService {
    /**
     * 发送消息。
     * @param type 接收者类型：0-好友；1-群组。
     * @param receiver 接收者ID。
     * @param format   消息格式：0-文本；1-图片；2-音频；3-视频；4-文件；5-红包。
     * @param content  消息内容。
     * @return 如果发送成功则返回true；否则返回false。
     */
    boolean send(int type,String receiver, int format, String content);

    /**
     * 检索当前用户最新信息集。
     *
     * @param time 最近一次获取时间戳，单位：毫秒。
     * @return 最新信息集。
     */
    JSONObject newest(long time);
}