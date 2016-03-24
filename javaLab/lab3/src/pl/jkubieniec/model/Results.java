/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * package pl.jkubieniec.model cointain class responsible for program logic 
 */
package pl.jkubieniec.model;

/**
 * My own generic type to stored single results
 * @author Julia Kubieniec
 * @version 1.0
 */
public class Results<T1,T2> {

    /**
     * users nick
     */
    private T1 nick;
    /**
     * number of quiz in which user get 'score' points 
     */
    private T1 whichQuiz;
    /**
     * number of points scored in the quiz 'whichQuiz'
     */
    private T2 score;
    
    /**
     * constructor
     * @param nick users nick
     * @param whichQuiz number of quiz in which user get 'score' points 
     * @param score number of points scored in the quiz 'whichQuiz'
     */
    Results(T1 nick, T1 whichQuiz, T2 score) {
        this.nick = nick;
        this.whichQuiz = whichQuiz;
        this.score = score;
    }

    /**
     * @return the nick
     */
    public T1 getNick() {
        return nick;
    }

    /**
     * @param nick the nick to set
     */
    public void setNick(T1 nick) {
        this.nick = nick;
    }

    /**
     * @return the whichQuiz
     */
    public T1 getWhichQuiz() {
        return whichQuiz;
    }

    /**
     * @param whichQuiz the whichQuiz to set
     */
    public void setWhichQuiz(T1 whichQuiz) {
        this.whichQuiz = whichQuiz;
    }

    /**
     * @return the score
     */
    public T2 getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(T2 score) {
        this.score = score;
    }
    
}
