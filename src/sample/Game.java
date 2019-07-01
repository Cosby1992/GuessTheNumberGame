package sample;

import java.util.ArrayList;

public class Game {

    private int magicNumber;
    private int guess;

    private int numOfTries;

    private String status;
    private boolean won;

    private ArrayList<Integer> guesses;

    public void startNewGame(){
        magicNumber = generateMagicNumer();
        guess = 0;

        won = false;
        status = "";
        numOfTries = 0;

        guesses = new ArrayList<>();
    }


    public Game() {

        startNewGame();

    }

    public int generateMagicNumer(){
        return (int)((Math.random()*100)+1);
    }

    public void evaluateGuess(){

        String status;
        numOfTries++;

        if(magicNumber == guess){
            won = true;
            status = "Tillykke du gættede det magiske tal!";
        } else if(guess < magicNumber){
            status = "Det magiske tal er højere!";
        } else if(guess > magicNumber){
            status = "Det magiske tal er lavere!";
        } else {
            status ="";
        }

        guesses.add(guess);

        this.status = status;

    }

    public ArrayList<Integer> getGuesses() {
        return guesses;
    }

    public void setGuesses(ArrayList<Integer> guesses) {
        this.guesses = guesses;
    }

    public int getNumOfTries() {
        return numOfTries;
    }

    public void setNumOfTries(int numOfTries) {
        this.numOfTries = numOfTries;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }
}
