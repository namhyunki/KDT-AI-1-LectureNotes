package kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter;

import kr.eddi.demo.lectureClass.utility.random.CustomRandom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class CharacterCreationForm {

    private String selectedGender;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int characterId;
    private int myAccountId;

    public CharacterCreationForm(String gender, int characterId, int myAccountId) {
        final int STATUS_MIN = 1;
        final int STATUS_MAX = 10;

        this.selectedGender = gender;
        this.strength = CustomRandom.generateNumber(STATUS_MIN, STATUS_MAX);
        this.dexterity = CustomRandom.generateNumber(STATUS_MIN, STATUS_MAX);
        this.intelligence = CustomRandom.generateNumber(STATUS_MIN, STATUS_MAX);
        this.characterId = characterId;
        this.myAccountId = myAccountId;
    }
    public Character toCharacter(String gender, int characterId, int myAccountId) {
        return new Character(
                gender, strength, dexterity, intelligence, characterId, myAccountId
        );
    }

}