package com.rongsoft.dts.demo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "card_bin")
public class CardBin implements Serializable,Cloneable {

//    @Id
//    @Column(name = "card_bin_id")
//    private String cardBinId;
//    @Column(name = "card_length")
//    private Integer cardLength;
//    @Column(name = "card_type")
//    private String cardType;
//    @Column(name = "card_name")
//    private String cardName;
//    @Column(name = "org_code")
//    private String orgCode;
//    @Column(name = "bank_name")
//    private String bankName;
//    @Column(name = "bank_code")
//    private String bankCode;
//    @Column(name = "create_time")
//    private Date createTime;

    private String cardBinId;
    private Integer cardLength;
    private String cardType;
    private String cardName;
    private String orgCode;
    private String bankName;
    private String bankCode;
    private Date createTime;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}