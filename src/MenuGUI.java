import java.awt.*;
import javax.swing.*;

public class MenuGUI extends JFrame {
    public MenuGUI() {
        setTitle("Pokémon Card Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ✅ Load Background Image
        ImageIcon backgroundImage = new ImageIcon(getClass().getClassLoader().getResource("assets/pokemon.png"));
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());

        // ✅ Layered Pane to Keep Title & Buttons on Top
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 600));

        // ✅ Background Panel
        backgroundLabel.setBounds(0, 0, 800, 600);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // ✅ Title Label (Foreground Layer)
        JLabel titleLabel = new JLabel("Pokémon Card Game", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 50, 800, 50); // Adjust Y position
        layeredPane.add(titleLabel, JLayeredPane.PALETTE_LAYER); // Upper Layer

        // ✅ Button Panel (Foreground Layer)
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setOpaque(false);
        buttonPanel.setBounds(250, 200, 300, 150); // Centered button position

        // ✅ Buttons
        JButton startButton = new JButton("Start Game");
        JButton rulesButton = new JButton("Rules");
        JButton quitButton = new JButton("Quit");

        startButton.addActionListener(e -> {
            System.out.println("Start Game Clicked!");
            SwingUtilities.invokeLater(() -> new GameGUI());
            dispose();
        });

        // ✅ Improved Rules Display
        rulesButton.addActionListener(e -> showGameRules());

        quitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(startButton);
        buttonPanel.add(rulesButton);
        buttonPanel.add(quitButton);

        layeredPane.add(buttonPanel, JLayeredPane.MODAL_LAYER); // Upper Layer

        add(layeredPane);
        setVisible(true);
    }

    // ✅ Function to Show Full Game Rules
    private void showGameRules() {
        String rulesText = """
            <html>
            <h2 style='text-align: center;'>Pokémon Card Game Rules</h2>
            <br>
            <b>1. Game Setup:</b><br>
            - Each player starts with a shuffled deck.<br>
            - Players draw 7 cards at the beginning.<br>
            - A coin flip decides who plays first.<br>
            - The first player <b>cannot attack</b> on their first turn.<br><br>

            <b>2. Turn Structure:</b><br>
            - Each turn consists of:<br>
              • <b>Draw</b> a card (Mandatory).<br>
              • <b>Play Pokémon</b>, attach Energy, or use Trainer cards (Optional).<br>
              • <b>Attack</b> the opponent’s Active Pokémon (If possible).<br>
              • <b>End turn</b>, switching to the other player.<br><br>

            <b>3. Playing Cards:</b><br>
            - Pokémon must be placed on the <b>bench</b> before being used in battle.<br>
            - Energy cards are <b>attached</b> to Pokémon for attacks.<br>
            - Trainer cards provide <b>special effects</b>.<br><br>

            <b>4. Battle Rules:</b><br>
            - Players attack using their <b>Active Pokémon</b>.<br>
            - If a Pokémon’s <b>HP reaches 0</b>, it is knocked out.<br>
            - The winner collects a <b>Prize Card</b> after knocking out an opponent’s Pokémon.<br><br>

            <b>5. Winning Conditions:</b><br>
            - A player wins if:<br>
              • They collect <b>all 3 Prize Cards</b>.<br>
              • The opponent has <b>no Pokémon left</b>.<br>
              • The opponent runs out of cards to <b>draw</b>.<br><br>

            <b>6. Special Mechanics:</b><br>
            - Status effects like <b>Paralyze, Burn, and Sleep</b> impact gameplay.<br>
            - Players must manage <b>Energy Cards</b> effectively.<br>
            - <b>Prize Cards</b> are drawn after every knockout.<br><br>

            <center><b>🎉 Enjoy the game! 🎉</b></center>
            </html>
            """;

        // Use JTextPane to render HTML
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setText(rulesText);
        textPane.setEditable(false);
        textPane.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(450, 350));

        JOptionPane.showMessageDialog(this, scrollPane, "Game Rules", JOptionPane.INFORMATION_MESSAGE);
    }

}
