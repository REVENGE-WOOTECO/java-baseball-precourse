package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

import static utils.Constant.*;

public class NumberGenerator {

    public String numberGenerate(){
        StringBuilder answer = new StringBuilder();
        HashSet<Integer> duplicateCheck = new HashSet<>();

        while (answer.length() != DIGIT){
            int randomNumber = Randoms.pickNumberInRange(START_OF_NUMBER_RANGE, END_OF_NUMBER_RANGE);
            if(!duplicateCheck.contains(randomNumber)){
                duplicateCheck.add(randomNumber);
                answer.append(randomNumber);
            }
        }
        return answer.toString();
    }
}
