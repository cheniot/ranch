package org.lpw.ranch.group.member;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author lpw
 */
public interface MemberService {
    /**
     * 类型。
     */
    enum Type {
        /**
         * 0-待审核
         */
        New,
        /**
         * 1-普通成员
         */
        Normal,
        /**
         * 2-管理员
         */
        Manager,
        /**
         * 3-所有者
         */
        Owner
    }

    /**
     * 成员是否存在验证器Bean名称。
     */
    String VALIDATOR_EXISTS = MemberModel.NAME + ".validator.exists";
    /**
     * 用户是否存在验证器Bean名称。
     */
    String VALIDATOR_USER_EXISTS = MemberModel.NAME + ".validator.user.exists";
    /**
     * 当前用户是否为群组管理员验证器Bean名称。
     */
    String VALIDATOR_MANAGER = MemberModel.NAME + ".validator.manager";
    /**
     * 当前用户是否为成员本身或群组管理员验证器Bean名称。
     */
    String VALIDATOR_SELF_MANAGER = MemberModel.NAME + ".validator.self-manager";

    /**
     * 获取成员信息。
     *
     * @param id ID值。
     * @return 成员信息；如果不存在则返回null。
     */
    MemberModel findById(String id);

    /**
     * 获取成员信息。
     *
     * @param group 群组ID值。
     * @param user  用户ID值。
     * @return 成员信息；如果不存在则返回空JSON。
     */
    JSONObject find(String group, String user);

    /**
     * 检索群组的成员集。
     *
     * @param group 群组ID。
     * @return 成员集。
     */
    JSONArray queryByGroup(String group);

    /**
     * 检索用户所属的群组成员集。
     *
     * @param user 用户ID。
     * @return 成员集。
     */
    List<MemberModel> queryByUser(String user);

    /**
     * 创建所有者成员。
     *
     * @param group 组ID。
     * @param owner 所有者ID。
     */
    void create(String group, String owner);

    /**
     * 加入群组。
     *
     * @param group      群组ID。
     * @param user       用户ID，为空则表示当前用户。
     * @param reason     申请加入理由。
     * @param introducer 介绍人ID。
     */
    void join(String group, String user, String reason, String introducer);

    /**
     * 通过审核。
     *
     * @param id 申请ID。
     */
    void pass(String id);

    /**
     * 拒绝加入申请。
     *
     * @param id 申请ID。
     */
    void refuse(String id);

    /**
     * 设置成员为管理员。
     *
     * @param id 成员ID。
     */
    void manager(String id);

    /**
     * 设置群组昵称。
     *
     * @param id 成员ID。
     */
    void nick(String id, String nick);

    /**
     * 推出/踢出群组。
     *
     * @param id 成员ID。
     */
    void leave(String id);
}
