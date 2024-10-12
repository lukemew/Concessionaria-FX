package program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JRadioButton radioCliente;
    private JRadioButton radioVendedor;
    private JButton btnLogin;

    public TelaLogin() {
        setTitle("Login - Concessionária TOPcar");
        setSize(500, 350); // Ajuste do tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Fonte sem serifa e configuração de estilo geral
        Font fonteSemSerifa = new Font("SansSerif", Font.PLAIN, 16);
        Font fonteCabecalho = new Font("SansSerif", Font.BOLD, 22);

        // Configurando o layout e estilo dos painéis
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(30, 30, 30)); // Fundo escuro

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Adicionando o cabeçalho
        JLabel lblCabecalho = new JLabel("Concessionária TOPcar", JLabel.CENTER);
        lblCabecalho.setForeground(new Color(255, 215, 0)); // Amarelo para o texto
        lblCabecalho.setBackground(Color.BLACK); // Fundo preto
        lblCabecalho.setOpaque(true);
        lblCabecalho.setFont(fonteCabecalho);
        lblCabecalho.setHorizontalAlignment(JLabel.CENTER);

        gbc.gridwidth = 2;
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(lblCabecalho, gbc);
        gbc.gridwidth = 1; // Resetando após o cabeçalho

        // Criando os componentes com cores e fontes ajustadas
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(fonteSemSerifa);

        txtUsuario = new JTextField();
        txtUsuario.setBackground(new Color(50, 50, 50)); // Fundo do campo de texto
        txtUsuario.setForeground(Color.WHITE);
        txtUsuario.setFont(fonteSemSerifa);
        txtUsuario.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setFont(fonteSemSerifa);

        txtSenha = new JPasswordField();
        txtSenha.setBackground(new Color(50, 50, 50)); // Fundo da senha
        txtSenha.setForeground(Color.WHITE);
        txtSenha.setFont(fonteSemSerifa);
        txtSenha.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));

        radioCliente = new JRadioButton("Cliente");
        radioCliente.setBackground(new Color(30, 30, 30)); // Fundo para combinar
        radioCliente.setForeground(Color.WHITE);
        radioCliente.setFont(fonteSemSerifa);

        radioVendedor = new JRadioButton("Vendedor");
        radioVendedor.setBackground(new Color(30, 30, 30)); // Fundo para combinar
        radioVendedor.setForeground(Color.WHITE);
        radioVendedor.setFont(fonteSemSerifa);

        btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(70, 130, 180)); // Cor do botão
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(fonteSemSerifa);
        btnLogin.setFocusPainted(false);

        ButtonGroup group = new ButtonGroup();
        group.add(radioCliente);
        group.add(radioVendedor);

        // Adicionando componentes ao painel
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(lblUsuario, gbc);

        gbc.gridx = 1;
        panel.add(txtUsuario, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(lblSenha, gbc);

        gbc.gridx = 1;
        panel.add(txtSenha, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(radioCliente, gbc);

        gbc.gridx = 1;
        panel.add(radioVendedor, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        panel.add(btnLogin, gbc);

        add(panel);

        // Ação do botão de login com verificação de credenciais
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());

                if (usuario.equals("user") && senha.equals("12345")) {
                    if (radioCliente.isSelected()) {
                        // Redirecionando para a tela de cliente
                        new TelaCliente().setVisible(true);
                    } else if (radioVendedor.isSelected()) {
                        // Redirecionando para a tela de vendedor
                        new TelaVendedor().setVisible(true);
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}
