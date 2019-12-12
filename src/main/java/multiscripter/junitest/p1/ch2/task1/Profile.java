package multiscripter.junitest.p1.ch2.task1;

import java.util.HashMap;
import java.util.Map;

/**
 * Профиль содержит ответы на соответствующие вопросы, которые может задать
 * компания или соискатель.
 */
public class Profile {

    private Map<String, Answer> answers = new HashMap<>();

    private int score;

    private String name;

    public Profile(final String pName) {
        this.name = pName;
    }

    /**
     * Adds answer for question.
     * @param answer an answer.
     */
    public void add(Answer answer) {
        this.answers.put(answer.getQuestionText(), answer);
    }

    /**
     * Определяет совпадает ли критерий с ответами в профиле.
     * @param criteria
     * @return
     */
    public boolean matches(Criteria criteria) {
        score = 0;
        boolean kill = false;
        boolean anyMatches = false;

        // Перебрать каждый критерий.
        for (Criterion criterion : criteria) {
            Answer answer = answers.get(criterion.getAnswer().getQuestionText());
            boolean match = criterion.getWeight()
                    == Weight.DontCare || answer.match(criterion.getAnswer());

            if (!match && criterion.getWeight() == Weight.MustMatch) {
                kill = true;
            }
            /**
             * Метод match() также имеет побочный эффект: когда критерий
             * соответствует ответу в профиле, оценка для профиля увеличивается
             * на взвешенное значение критерия.
             */
            if (match) {
                score += criterion.getWeight().getValue();
            }
            // побитовое ИЛИ и оператор присваивания.
            anyMatches |= match;
        }
        if (kill) {
            return false;
        }
        return anyMatches;
    }

    public int score() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }
}
