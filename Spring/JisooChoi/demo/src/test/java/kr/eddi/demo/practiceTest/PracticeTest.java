package kr.eddi.demo.practiceTest;

import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.controller.form.TestPracticeAccountRequestForm;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.controller.form.TestPracticeResponseForm;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.entity.TestPracticeAccount;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.service.TestPracticeAccountService;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.controller.form.TestPracticeProductRequestForm;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.entity.TestPracticeProduct;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.service.TestPracticeProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class PracticeTest {
    @Autowired
    private TestPracticeAccountService testPracticeAccountService;

    @Autowired
    private TestPracticeProductService testPracticeProductService;

    @Test
    @DisplayName("사용자가 정보를 기입하면 회원 가입이 완료됩니다.")
    void 사용자가_회원가입을_합니다 () {
        final String email = "test@test.com";
        final Integer password = 1234;
        final String accountRole = "일반회원";

        /*
            사용자의 정보가 RequestForm 으로 전달되어 객체가 생성된다.

            객체로 만들어진 RequestForm 은
            import 로 @RequiredArgsConstructor 를 불러와서 사용하기 때문에
            따로 생성자를 만들어주지 않아도 필요한 모든 값이 들어오면 해당 객체를 생성해준다.
         */
        TestPracticeAccountRequestForm requestForm = new TestPracticeAccountRequestForm(email, password, accountRole);

        /*
            생성된 객체를 가지고 등록이라는 "기능"을 실행한다.

            기능은 서비스가 처리하므로,
            서비스에게 requestForm 에 대한 정보로 register 를 해줘~! 라고 요청한 것이다.
         */
        TestPracticeAccount account = testPracticeAccountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
        assertEquals(accountRole, account.getAccountRole());
    }

    @Test
    @DisplayName("회원이 로그인을 하면 해당 계정 존재여부 확인 후 로그인이 됩니다.")
    void 회원이_로그인을_합니다 () {
        final String email = "test@test.com";
        final Integer password = 1234;
        final String accountRole = "일반회원";

        TestPracticeAccountRequestForm requestForm = new TestPracticeAccountRequestForm(email, password, accountRole);
        TestPracticeResponseForm responseForm = testPracticeAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() != null);
    }
}
