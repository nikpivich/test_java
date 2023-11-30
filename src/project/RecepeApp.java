package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RecepeApp {
    private static List<Recipe> recipes = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Приложение с рецептами");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JTextArea recipeTextArea = new JTextArea();
        recipeTextArea.setEditable(false);

        JButton addButton = new JButton("Добавить рецепт");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recipeName = JOptionPane.showInputDialog("Введите название рецепта:");
                if (recipeName != null && !recipeName.trim().isEmpty()) {
                    Recipe newRecipe = new Recipe(recipeName);
                    recipes.add(newRecipe);
                    updateRecipeList(recipeTextArea);
                }
            }
        });

        panel.add(new JScrollPane(recipeTextArea), BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.SOUTH);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private static void updateRecipeList(JTextArea recipeTextArea) {
        StringBuilder recipeList = new StringBuilder();
        for (Recipe recipe : recipes) {
            recipeList.append(recipe.getName()).append("\n");
        }
        recipeTextArea.setText(recipeList.toString());
    }

    private static class Recipe {
        private String name;

        public Recipe(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
