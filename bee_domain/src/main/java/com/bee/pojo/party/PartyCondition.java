package com.bee.pojo.party;

import javax.persistence.*;

/**
 * Created by suntongwei on 16/1/5.
 */
@Entity
@Table(name = "TB_PARTY_CONDITION")
public class PartyCondition implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -1844517054076482350L;

    // 主键
    private Long pcId;
    // 所属活动
    private Party party;
    // 所需等级
    private Integer level;
    // 所需经验
    private Integer exp;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PCID", unique = true, nullable = false)
    public Long getPcId() {
        return pcId;
    }
    public void setPcId(Long pcId) {
        this.pcId = pcId;
    }
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "PARTY")
    public Party getParty() {
        return party;
    }
    public void setParty(Party party) {
        this.party = party;
    }
    @Column(name = "LEVEL")
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    @Column(name = "EXP")
    public Integer getExp() {
        return exp;
    }
    public void setExp(Integer exp) {
        this.exp = exp;
    }
}
