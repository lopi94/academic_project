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
 * My own generic type to stored single question
 * @author Julia Kubieniec
 * @version 1.0
 */
public class Question<T> {
   /**
    * variable to stored question
    */
   private T question;
   /**
    * variable to stored answer A
    */
   private T answerA;
   /**
    * variable to stored answer B
    */
   private T answerB;
   /**
    * variable to stored answer C
    */
   private T answerC;
   /**
    * variable to stored correct answer 
    */
   private T answerOk;
   /**
    * variable to stored user answer 
    */
   private T answerUser;
    
   /**
    * constructor
    * @param question
    * @param answerA
    * @param answerB
    * @param answerC
    * @param answerOk
    * @param answerUser 
    */
   Question(T question,T answerA,T answerB,T answerC,T answerOk, T answerUser) {
       this.question = question;
       this.answerA = answerA;
       this.answerB = answerB;
       this.answerC = answerC;
       this.answerOk = answerOk;
       this.answerUser = answerUser;
   }
   
   /**
     * @return the question
     */
    public T getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(T question) {
        this.question = question;
    }

    /**
     * @return the answerA
     */
    public T getAnswerA() {
        return answerA;
    }

    /**
     * @param answerA the answerA to set
     */
    public void setAnswerA(T answerA) {
        this.answerA = answerA;
    }

    /**
     * @return the answerB
     */
    public T getAnswerB() {
        return answerB;
    }

    /**
     * @param answerB the answerB to set
     */
    public void setAnswerB(T answerB) {
        this.answerB = answerB;
    }

    /**
     * @return the answerC
     */
    public T getAnswerC() {
        return answerC;
    }

    /**
     * @param answerC the answerC to set
     */
    public void setAnswerC(T answerC) {
        this.answerC = answerC;
    }

    /**
     * @return the answerOk
     */
    public T getAnswerOk() {
        return answerOk;
    }

    /**
     * @param answerOk the answerOk to set
     */
    public void setAnswerOk(T answerOk) {
        this.answerOk = answerOk;
    }

    /**
     * @return the answerUser
     */
    public T getAnswerUser() {
        return answerUser;
    }

    /**
     * @param answerUser the answerUser to set
     */
    public void setAnswerUser(T answerUser) {
        this.answerUser = answerUser;
    }
    
    
}
