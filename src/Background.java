import java.awt.*;
import javax.swing.*;

public class Background {
    public void gerarBack() {
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
        int larguraMonitor = tamanhoTela.width;
        int alturaMonitor = tamanhoTela.height;

        ImageIcon iconeOriginal = new ImageIcon("src/img/fundoBet.jpeg");
        Image imagem = iconeOriginal.getImage();
      
        Image imagemRedimensionada = imagem.getScaledInstance(larguraMonitor, alturaMonitor, Image.SCALE_SMOOTH);

        ImageIcon iconeTelaCheia = new ImageIcon(imagemRedimensionada);

        JLabel labelImagem = new JLabel(iconeTelaCheia);
        frame.add(labelImagem);

        frame.setVisible(true);
    }
}