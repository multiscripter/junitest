package multiscripter.junitest.p1.ch2.task1;

/**
 * Критерий представляет то, что работодатель
 * ищет в работнике или наоборот. Он инкапсулирует объект ответа и
 * Вес объекта, который показывает, насколько важен правильный ответ на вопрос.
 */
public class Criterion implements Scoreable {

    private Weight weight;

    private Answer answer;

    private int score;

    public Criterion(Answer answer, Weight weight) {
        this.answer = answer;
        this.weight = weight;
    }

    public Answer getAnswer() {
        return answer;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
