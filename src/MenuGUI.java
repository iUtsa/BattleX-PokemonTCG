import javax.swing.*;
import java.awt.*;

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

        rulesButton.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Rules:\n- Each player gets 7 cards\n- Players take turns\n- First to lose all Pokémon loses.",
                "Game Rules", JOptionPane.INFORMATION_MESSAGE));

        quitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(startButton);
        buttonPanel.add(rulesButton);
        buttonPanel.add(quitButton);

        layeredPane.add(buttonPanel, JLayeredPane.MODAL_LAYER); // Upper Layer

        add(layeredPane);
        setVisible(true);
    }
}
