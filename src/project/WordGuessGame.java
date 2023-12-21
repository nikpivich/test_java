package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class WordGuessGame {

    private String[] words = {"java", "swing", "programming", "computer", "algorithm", "coding"};
    private String selectedWord;
    private StringBuilder guessedWord;
    private int attemptsLeft;
    private JFrame frame;
    private JLabel wordLabel, attemptsLabel;
    private JTextField guessField;
    private JButton guessButton, newGameButton;

    public WordGuessGame() {
        frame = new JFrame("Word Guess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        initializeGame();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        wordLabel = new JLabel("Word: " + guessedWord.toString());
        attemptsLabel = new JLabel("Attempts left: " + attemptsLeft);
        guessField = new JTextField();
        guessButton = new JButton("Guess");
        newGameButton = new JButton("New Game");

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processGuess();
            }
        });

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeGame();
                updateUI();
            }
        });

        panel.add(wordLabel);
        panel.add(attemptsLabel);
        panel.add(new JLabel("Your guess:"));
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(newGameButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void initializeGame() {
        Random random = new Random();
        selectedWord = words[random.nextInt(words.length)];
        guessedWord = new StringBuilder("_".repeat(selectedWord.length()));
        attemptsLeft = 6;
    }

    private void processGuess() {
        if (attemptsLeft > 0) {
            String guess = guessField.getText().toLowerCase();
            if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
                checkGuess(guess.charAt(0));
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a valid single letter.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "You have run out of attempts. The word was: " + selectedWord);
            initializeGame();
        }
        updateUI();
    }

    private void checkGuess(char letter) {
        boolean correctGuess = false;
        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.charAt(i) == letter && guessedWord.charAt(i) == '_') {
                guessedWord.setCharAt(i, letter);
                correctGuess = true;
            }
        }

        if (!correctGuess) {
            attemptsLeft--;
        }

        if (guessedWord.toString().equals(selectedWord)) {
            JOptionPane.showMessageDialog(frame, "Congratulations! You guessed the word: " + selectedWord);
            initializeGame();
        }
    }

    private void updateUI() {
        wordLabel.setText("Word: " + guessedWord.toString());
        attemptsLabel.setText("Attempts left: " + attemptsLeft);
        guessField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordGuessGame();
            }
        });
    }
}

