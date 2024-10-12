package program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.dao.impl.VeiculoDaoJDBC;
import model.Veiculo;
import db.DB;

public class TelaCliente extends JFrame {

    private JPanel panel;
    private JButton[] btnTestDrive;
    private JLabel[] lblCarro;
    private JLabel[] lblImagem;
    private JButton btnSair;
    private VeiculoDaoJDBC veiculoDao;
    private List<Veiculo> listaVeiculos;

    public TelaCliente() {
        // Conexão com o banco de dados
        veiculoDao = new VeiculoDaoJDBC(DB.getConnection()); // Instancia o VeiculoDaoJDBC
        listaVeiculos = veiculoDao.buscarTodosVeiculos(); // Busca os veículos do banco

        setTitle("Área do Cliente - Concessionária TOPcar");
        setSize(800, 600); // Tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel(new GridLayout(6, 3, 10, 10)); // Layout de grade para 6 carros (3 colunas)
        panel.setBackground(new Color(30, 30, 30)); // Fundo escuro

        // Definindo os caminhos das imagens
        String[] imagens = {
                "src/imagens/bmw_serie3.png",     // Caminho da imagem do BMW X1
                "src/imagens/chevrolet_camaro.png",    // Caminho da imagem do Audi A3
                "src/imagens/ford_mustang.png", // Caminho da imagem do Ford Mustang
                "src/imagens/toyotacorolla.png",// Caminho da imagem do Toyota Corolla
                "src/imagens/mercedes-benz_classe_c.png",// Caminho da imagem do Mercedes GLA
                "src/imagens/honda_civic2.png"// Caminho da imagem do Honda Civic
        };

        btnTestDrive = new JButton[listaVeiculos.size()];
        lblCarro = new JLabel[listaVeiculos.size()];
        lblImagem = new JLabel[6];  // Tamanho fixo para 6 carros

        Font fonteTexto = new Font("SansSerif", Font.PLAIN, 16);

        // Preenche o painel com os carros vindos do banco de dados
        for (int i = 0; i < listaVeiculos.size(); i++) {
            Veiculo veiculo = listaVeiculos.get(i); // Pega o veículo atual da lista

            // Adicionando a imagem estática com base no índice (na coluna esquerda)
            lblImagem[i] = new JLabel();
            lblImagem[i].setIcon(redimensionarImagem(imagens[i], 150, 100)); // Redimensionando para 150x100 pixels
            lblImagem[i].setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(lblImagem[i]);

            // Adicionando os detalhes do carro (centralizado na coluna do meio)
            lblCarro[i] = new JLabel("<html>Modelo: " + veiculo.getModelo() + "<br>Cor: " + veiculo.getCor() + "</html>");
            lblCarro[i].setForeground(Color.WHITE);
            lblCarro[i].setFont(fonteTexto);
            lblCarro[i].setHorizontalAlignment(SwingConstants.CENTER); // Centralizado
            panel.add(lblCarro[i]);

            // Botão para agendar test drive (na coluna da direita)
            btnTestDrive[i] = new JButton("Agendar Test Drive");
            btnTestDrive[i].setBackground(Color.BLACK);
            btnTestDrive[i].setForeground(Color.white);
            btnTestDrive[i].setFont(fonteTexto);
            btnTestDrive[i].setFocusPainted(false);
            btnTestDrive[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            btnTestDrive[i].addActionListener(new AgendarTestDriveListener(i)); // Ação ao clicar no botão
            panel.add(btnTestDrive[i]);
        }

        // Adicionando botão de sair no topo
        btnSair = new JButton("Sair");
        btnSair.setBackground(Color.BLACK);
        btnSair.setForeground(Color.YELLOW);
        btnSair.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnSair.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
        btnSair.setFocusPainted(false);
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volta para a tela de login
                new TelaLogin().setVisible(true);
                dispose();
            }
        });

        // Painel principal com BorderLayout
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(30, 30, 30));

        // Painel para o botão de sair no canto superior direito
        JPanel painelSuperior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelSuperior.setBackground(new Color(30, 30, 30));
        painelSuperior.add(btnSair);

        painelPrincipal.add(painelSuperior, BorderLayout.NORTH);
        painelPrincipal.add(new JScrollPane(panel), BorderLayout.CENTER);

        add(painelPrincipal);
    }

    // Função para redimensionar a imagem
    private ImageIcon redimensionarImagem(String caminhoImagem, int largura, int altura) {
        ImageIcon icone = new ImageIcon(caminhoImagem);
        Image imagem = icone.getImage();
        Image imagemRedimensionada = imagem.getScaledInstance(largura, altura, Image.SCALE_SMOOTH); // Redimensiona a imagem
        return new ImageIcon(imagemRedimensionada);
    }

    // Classe interna para lidar com o evento de agendar test drive
    private class AgendarTestDriveListener implements ActionListener {
        private int index;

        public AgendarTestDriveListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realizar um test drive com o " + listaVeiculos.get(index).getModelo() + "?", "Confirmar Test Drive", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Test Drive realizado com sucesso!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCliente().setVisible(true));
    }
}
