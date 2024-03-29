package com.bee.pojo.store;

import com.bee.commons.Consts;
import com.qsd.framework.commons.utils.DateUtil;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/10/21.
 */
@Entity
@Table(name = "TB_PHONE_CARD")
public class PhoneCard implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 1112654431931184932L;

    // 主键
    private Long pcId;
    // 卡密
    private String cardNumber;
    // 运营商
    private Integer operator;
    // 是否兑换
    private Integer status;
    // 创建时间
    private Long createTime;

    @Transient
    public String getOperatorStr() {
        return Consts.GetOperatorSelect().get(operator);
    }

    @Transient
    public String getStatusStr() {
        String ret;
        switch (status) {
            case Consts.Goods.PhoneCard.Status.UnUse:
                ret = "未兑换";
                break;
            case Consts.Goods.PhoneCard.Status.Used:
                ret = "已兑换";
                break;
            default:
                ret = "未知";
        }
        return ret;
    }

    @Transient
    public String getCreateTimeStr() {
        return DateUtil.formatDateTime(createTime);
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PCID", unique = true, nullable = false)
    public Long getPcId() {
        return pcId;
    }
    public void setPcId(Long pcId) {
        this.pcId = pcId;
    }
    @Column(name = "CARDNUMBER")
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    @Column(name = "OPERATOR")
    public Integer getOperator() {
        return operator;
    }
    public void setOperator(Integer operator) {
        this.operator = operator;
    }
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
