package kr.eddi.demo.lectureClass.vue.controller.form.shop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
//@RequiredArgsConstructor
@NoArgsConstructor
public class AppleResponseForm2 {

    private Integer appleCountData;

    public AppleResponseForm2(Integer appleCountData) {
        this.appleCountData = appleCountData;
    }
}