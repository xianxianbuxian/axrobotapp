package com.zone.hospital.model;

import com.zone.hospital.model.bean.SicknissBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zone on 2017/4/12.
 * 肢体无力，瘫痪
 * 指（趾）端皮肤色泽改变
 * 肩关节疼痛
 * 皮肤疱疹
 * 关节活动受限
 * 关节疼痛
 * 上肢疼痛
 * 下肢疼痛
 */

public class SmartConsultModel {
    private static List<SicknissBean> manList;//1
    private static List<SicknissBean> womanList;//2
    private static List<SicknissBean> handAndFootList;//3
    private static List<SicknissBean> backList;//4
    private static List<SicknissBean> bellyList;//5
    private static List<SicknissBean> upHeadList;//6
    private static List<SicknissBean> downHeadList;//7
    private static List<SicknissBean> manChestList;//8
    private static List<SicknissBean> womanChestList;//9
    private static List<SicknissBean> arseList;//10
    public static List<SicknissBean> getArseList() {
        return arseList;
    }

    public static void setArseList(List<SicknissBean> arseList) {
        SmartConsultModel.arseList = arseList;
    }







    public static List<SicknissBean> getUpHeadList() {
        return upHeadList;
    }

    public static void setUpHeadList(List<SicknissBean> upHeadList) {
        SmartConsultModel.upHeadList = upHeadList;
    }

    public static List<SicknissBean> getDownHeadList() {
        return downHeadList;
    }

    public static void setDownHeadList(List<SicknissBean> downHeadList) {
        SmartConsultModel.downHeadList = downHeadList;
    }

    public static List<SicknissBean> getManChestList() {
        return manChestList;
    }

    public static void setManChestList(List<SicknissBean> manChestList) {
        SmartConsultModel.manChestList = manChestList;
    }

    public static List<SicknissBean> getWomanChestList() {
        return womanChestList;
    }

    public static void setWomanChestList(List<SicknissBean> womanChestList) {
        SmartConsultModel.womanChestList = womanChestList;
    }

    public static List<SicknissBean> getManList() {
        return manList;
    }

    public static void setManList(List<SicknissBean> manList) {
        SmartConsultModel.manList = manList;
    }

    public static List<SicknissBean> getWomanList() {
        return womanList;
    }

    public static void setWomanList(List<SicknissBean> womanList) {
        SmartConsultModel.womanList = womanList;
    }

    public static List<SicknissBean> getHandAndFootList() {
        return handAndFootList;
    }

    public static void setHandAndFootList(List<SicknissBean> handAndFootList) {
        SmartConsultModel.handAndFootList = handAndFootList;
    }

    public static List<SicknissBean> getBackList() {
        return backList;
    }

    public static void setBackList(List<SicknissBean> backList) {
        SmartConsultModel.backList = backList;
    }

    public static List<SicknissBean> getBellyList() {
        return bellyList;
    }

    public static void setBellyList(List<SicknissBean> bellyList) {
        SmartConsultModel.bellyList = bellyList;
    }

    public SmartConsultModel() {
        upHeadList = new ArrayList<>();
        upHeadList.add(new SicknissBean(""
                , new String[]{"","",""}
                , new String[]{"","",""}
                , new String[]{"","",""}
                , new String[]{"","",""}));


        manChestList = new ArrayList<>();
        manChestList.add(new SicknissBean(""
                , new String[]{"","",""}
                , new String[]{"","",""}
                , new String[]{"","",""}
                , new String[]{"","",""}));

        womanChestList = new ArrayList<>();
        womanChestList.add(new SicknissBean(""
                , new String[]{"","",""}
                , new String[]{"","",""}
                , new String[]{"","",""}
                , new String[]{"","",""}));


        upHeadList = new ArrayList<>();
        upHeadList.add(new SicknissBean("认知障碍"
                , new String[]{"记忆障碍","对人或事冷漠","主动活动少"}
                , new String[]{"老年痴呆家族史"}
                , new String[]{}
                , new String[]{"老年痴呆症"}));
        upHeadList.add(new SicknissBean("记忆障碍"
                , new String[]{"记忆障碍","对人或事冷漠","主动活动少"}
                , new String[]{"老年痴呆家族史"}
                , new String[]{}
                , new String[]{"老年痴呆症"}));
        upHeadList.add(new SicknissBean("头部肿块"
                , new String[]{}
                , new String[]{}
                , new String[]{}
                , new String[]{"头皮血肿"}));
        upHeadList.add(new SicknissBean("打呼噜"
                , new String[]{"头痛","极度嗜睡",""}
                , new String[]{}
                , new String[]{}
                , new String[]{"睡眠呼吸暂停综合症"}));
        upHeadList.add(new SicknissBean("脓鼻涕"
                , new String[]{"鼻子发干","鼻塞","鼻音"}
                , new String[]{"刺激性气体吸入","过敏体质","细菌感染"}
                , new String[]{}
                , new String[]{"鼻炎"}));
        upHeadList.add(new SicknissBean("虹视"
                , new String[]{"事物模糊","眼球胀痛","头痛"}
                , new String[]{"头面部创伤","药物因素"}
                , new String[]{}
                , new String[]{"青光眼","结膜炎","角膜炎"}));

        downHeadList = new ArrayList<>();
        downHeadList.add(new SicknissBean("认知障碍"
                , new String[]{"记忆障碍","对人或事冷漠","主动活动少"}
                , new String[]{"老年痴呆家族史"}
                , new String[]{}
                , new String[]{"老年痴呆症"}));
        downHeadList.add(new SicknissBean("记忆障碍"
                        , new String[]{"记忆障碍","对人或事冷漠","主动活动少"}
                        , new String[]{"老年痴呆家族史"}
                        , new String[]{}
                        , new String[]{"老年痴呆症"}));
        downHeadList.add(new SicknissBean("头部肿块"
                , new String[]{}
                , new String[]{}
                , new String[]{}
                , new String[]{"头皮血肿"}));
//        downHeadList.add(new SicknissBean(""
//                , new String[]{"","",""}
//                , new String[]{"","",""}
//                , new String[]{"","",""}
//                , new String[]{"","",""}));

        bellyList = new ArrayList<>();
        bellyList.add(new SicknissBean("呕吐"
                , new String[]{"腹胀","全腹痛","上腹痛"}
                , new String[]{"发热","恶心","反酸"}
                , new String[]{"便秘","乏力","尿频"}
                , new String[]{"急性肠胃炎","肠梗阻","胃炎"}));
        bellyList.add(new SicknissBean("反酸"
                , new String[]{"恶心","呕吐","便秘"}
                , new String[]{"左上腹痛","右上腹痛","胸痛"}
                , new String[]{"食用过冷或过刺激性食物","大量饮酒","大量饮茶或咖啡"}
                , new String[]{"反流性食管炎","消化性溃疡","胃炎"}));
        bellyList.add(new SicknissBean("左下腹痛"
                , new String[]{"腹泻","粘液脓血便","腹胀"}
                , new String[]{"发热","消瘦","腹部肿块"}
                , new String[]{"摄入食物不洁","",""}
                , new String[]{"细菌性痢疾","肠炎","肠梗阻"}));
        bellyList.add(new SicknissBean("全腹同"
                , new String[]{"发热","呕吐","腹胀"}
                , new String[]{"消瘦","吐血","反酸"}
                , new String[]{"腹腔手术史","酗酒","腹部创伤史"}
                , new String[]{"肠梗阻","慢性腹泻","急性腹膜炎"}));
//        bellyList.add(new SicknissBean("右下腹痛"
//                , new String[]{"","",""}
//                , new String[]{"","",""}
//                , new String[]{"","",""}
//                , new String[]{"","",""}));
//        bellyList.add(new SicknissBean("右上腹痛"
//                , new String[]{"","",""}
//                , new String[]{"","",""}
//                , new String[]{"","",""}
//                , new String[]{"","",""}));


        backList = new ArrayList<>();
        backList.add(new SicknissBean("背部肿块"
                , new String[]{}
                , new String[]{}
                , new String[]{}
                , new String[]{"脂肪瘤"}));
        backList.add(new SicknissBean("腰背痛"
                , new String[]{"关节活动受限","上肢疼痛","皮肤出血点"}
                , new String[]{"劳累","长期站立","长期过度劳动"}
                , new String[]{"疫源性动物接触史","曾患恶性肿瘤","痛风家族史"}
                , new String[]{"腰部慢性劳损","肾囊肿","骨质增生"}));
        backList.add(new SicknissBean("腰骶疼痛"
                , new String[]{"肢体疼痛","下腹痛","尿道口疼痛"}
                , new String[]{"会阴同","尿痛","尿频"}
                , new String[]{"肩背部创伤史","精神应激","个人卫生不洁"}
                , new String[]{"前列腺炎","腰椎间盘突出","骨质疏松"}));






        manList = new ArrayList<>();
//        manList.add(new SicknissBean("尿流中断"
//                , new String[]{"伸舌偏斜","共济失调","头痛"}
//                , new String[]{"肢体麻木","肌肉萎缩","肢体疼痛"}
//                , new String[]{"头面部创伤史","恶性肿瘤史","高血压史"}
//                , new String[]{"中风","营养不良","急性脊髓炎","周围神经病"}));
        manList.add(new SicknissBean("尿线变细"
                , new String[]{"尿频","尿急","尿痛 "}
                , new String[]{"会阴部创伤","排尿困难",""}
                , new String[]{"","",""}
                , new String[]{"前列腺增生","尿道狭窄",""}));
        manList.add(new SicknissBean("夜尿增多"
                , new String[]{"尿频","尿急","夜尿增多"}
                , new String[]{"高血压","",""}
                , new String[]{"","",""}
                , new String[]{"高血压肾病","前列腺增生",""}));
        manList.add(new SicknissBean("泡沫尿"
                , new String[]{"眼睑浮肿","下肢水肿","全身性水肿"}
                , new String[]{"糖尿病","近期呼吸道感染",""}
                , new String[]{"","",""}
                , new String[]{"肾病综合症","糖尿病肾病","肾炎"}));
        manList.add(new SicknissBean("无尿"
                , new String[]{"腰背痛","血尿","食欲不振"}
                , new String[]{"","",""}
                , new String[]{"","",""}
                , new String[]{"肾衰竭","肾输尿管结石",""}));
        manList.add(new SicknissBean("尿液浑浊"
                , new String[]{"尿频","尿急","尿痛"}
                , new String[]{"结核病","尿路结石","性生活活跃"}
                , new String[]{"","",""}
                , new String[]{"肾结石","膀胱结石","膀胱炎"}));
        manList.add(new SicknissBean("包皮口狭小"
                , new String[]{}
                , new String[]{}
                , new String[]{}
                , new String[]{"包茎"}));
        manList.add(new SicknissBean("包皮过长"
                , new String[]{}
                , new String[]{}
                , new String[]{}
                , new String[]{"包茎"}));
        manList.add(new SicknissBean("龟头疼痛"
                , new String[]{}
                , new String[]{}
                , new String[]{}
                , new String[]{"包皮龟头炎"}));


        womanList = new ArrayList<>();
//        womanList.add(new SicknissBean("尿流中断"
//                , new String[]{"伸舌偏斜","共济失调","头痛"}
//                , new String[]{"肢体麻木","肌肉萎缩","肢体疼痛"}
//                , new String[]{"头面部创伤史","恶性肿瘤史","高血压史"}
//                , new String[]{"中风","营养不良","急性脊髓炎","周围神经病"}));
        womanList.add(new SicknissBean("尿线变细"
                , new String[]{"尿频","尿急","尿痛"}
                , new String[]{"会阴部创伤","排尿困难"}
                , new String[]{}
                , new String[]{"前列腺增生","尿道狭窄",""}));
        womanList.add(new SicknissBean("夜尿增多"
                , new String[]{"尿频","尿急","夜尿增多"}
                , new String[]{"高血压"}
                , new String[]{}
                , new String[]{"高血压肾病","前列腺增生"}));
        womanList.add(new SicknissBean("泡沫尿"
                , new String[]{"眼睑浮肿","下肢水肿","全身性水肿"}
                , new String[]{"糖尿病","近期呼吸道感染"}
                , new String[]{}
                , new String[]{"肾病综合症","糖尿病肾病","肾炎"}));
        womanList.add(new SicknissBean("无尿"
                , new String[]{"腰背痛","血尿","食欲不振"}
                , new String[]{}
                , new String[]{}
                , new String[]{"肾衰竭","肾输尿管结石"}));
        womanList.add(new SicknissBean("尿液浑浊"
                , new String[]{"尿频","尿急","尿痛"}
                , new String[]{"结核病","尿路结石","性生活活跃"}
                , new String[]{}
                , new String[]{"肾结核","膀胱结石","膀胱炎"}));
        womanList.add(new SicknissBean("阴道流液"
                , new String[]{"白带异常","月经失调","阴道出血"}
                , new String[]{"产伤","个人卫生不洁","经期性生活"}
                , new String[]{}
                , new String[]{"阴道炎","胎膜早破","宫颈炎"}));
        womanList.add(new SicknissBean("尿道口疼痛"
                , new String[]{"尿频","尿急","尿痛"}
                , new String[]{"会阴痛","外阴瘙痒","淋巴结肿大"}
                , new String[]{"不洁性生活"}
                , new String[]{"尿道炎","淋病"}));
        womanList.add(new SicknissBean("尿道口红肿"
                , new String[]{"尿频","尿急","尿痛"}
                , new String[]{"不洁性生活"}
                , new String[]{}
                , new String[]{"尿道炎","淋病"}));



        handAndFootList = new ArrayList<>();
        handAndFootList.add(new SicknissBean("肢体无力，瘫痪"
                , new String[]{"伸舌偏斜","共济失调","头痛"}
                , new String[]{"肢体麻木","肌肉萎缩","肢体疼痛"}
                , new String[]{"头面部创伤史","恶性肿瘤史","高血压史"}
                , new String[]{"中风","肌营养不良症","急性脊髓炎","周围神经病"}));

        handAndFootList.add(new SicknissBean("指（趾）端皮肤色泽改变"
                , new String[]{"下肢疼痛","肢体麻木","间歇性跛行"}
                , new String[]{"肢体创伤史","肥胖","精神应激"}
                , new String[]{}
                , new String[]{"雷诺综合征","糖尿病","急性动脉栓塞"}));

        handAndFootList.add(new SicknissBean("肩关节疼痛"
                , new String[]{"肌肉萎缩","下肢疼痛","上肢疼痛"}
                , new String[]{"四肢创伤史","盆部创伤史","长期过度活动"}
                , new String[]{}
                , new String[]{"肩关节周围炎","骨折","脊髓炎"}));

        handAndFootList.add(new SicknissBean("皮肤疱疹"
                , new String[]{}
                , new String[]{}
                , new String[]{}
                , new String[]{"大疱性类天疱疹"}));

        handAndFootList.add(new SicknissBean("关节活动受限"
                , new String[]{"关节疼痛","肩部创伤","长期过度活动"}
                , new String[]{}
                , new String[]{}
                , new String[]{"关节脱位","关节炎","骨折"}));

        handAndFootList.add(new SicknissBean("关节疼痛"
                , new String[]{"关节活动受限","四肢肿块","下肢疼痛"}
                , new String[]{"背部创伤史","放射性物质接触史","家族相关病史"}
                , new String[]{"","",""}
                , new String[]{"关节炎","网球肘","关节脱位"}));


        handAndFootList.add(new SicknissBean("上肢疼痛"
                , new String[]{"头痛","下肢疼痛","关节畸形"}
                , new String[]{"四肢创伤史","盆部创伤","四肢手术史"}
                , new String[]{"","",""}
                , new String[]{"骨折","颈椎病","关节炎"}));

        handAndFootList.add(new SicknissBean("下肢疼痛"
                , new String[]{"头痛","上肢疼痛","关节畸形"}
                , new String[]{"吸烟","寒冷刺激","放射性物质接触史"}
                , new String[]{"四肢创伤","四肢手术史","盆部创伤"}
                , new String[]{"骨折","急性动脉血栓","关节脱位"}));
            arseList=new ArrayList<>();
        arseList.add(new SicknissBean("肛门突出物"
                , new String[]{"肛门突出物"}
                , new String[]{}
                , new String[]{}
                , new String[]{"痔疮","直肠脱垂"}));
        arseList.add(new SicknissBean("肛门痛"
                , new String[]{"便秘","皮肤瘙痒","鲜血便"}
                , new String[]{}
                , new String[]{}
                , new String[]{"肛裂","肛痿"}));

        arseList.add(new SicknissBean("便秘"
                , new String[]{"腹泻","腹痛"}
                , new String[]{}
                , new String[]{}
                , new String[]{"痔疮","大肠癌","胃功能紊乱"}));
    }


}
