
package statistika;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JOptionPane;


public class Statistika extends JFrame{

		private JLabel PnlUtama;
		private JLabel PnlAtas;
		private JLabel PnlMenu;
		private JLabel PnlJdlMenu;
		private JLabel PnlLayar;
		private JLabel PnlOutput1;
		private JLabel PnlOutput2;
		private JLabel PnlBawah;
		private JLabel BtnSort;
		private JLabel BtnHitung;
		private JLabel BtnInput;
		private JLabel BtnClear;
		private JLabel BtnAbout;
		private JLabel BtnExit;
		private JTextArea TxtInput;
		private JTextArea TxtOutput;
		private JTextField TxtMean;
		private JTextArea TxtModus;
		private JTextField TxtQ1;
		private JTextField TxtQ2;
		private JTextField TxtQ3;
		private JLabel LblInput;
		private JLabel LblOutput;
		private JLabel LblMean;
		private JLabel LblModus;
		private JLabel LblQ1;
		private JLabel LblQ2;
		private JLabel LblQ3;
		private JLabel animasijln;
			
		
		
		private Dimension dim;
		private ImageIcon gambar;
		private Timer tmrAnimLabel;    
		private int flag; 
		
			
		private int i, j, indeks, jum, loop = 1, des;
		private int arrayInput[] = new int [100];
		private int arrayModus[][] = new int [100][3];
		private int temp, rata2, a, median, b = 0, c = arrayInput[0], hasil = 0, besar = 0;
	
		public Statistika(){
			MenuMenu();
			dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocationRelativeTo(this);
			this.setTitle("Aplikasi Statistika Data Tunggal");
			this.setSize(527,350);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			this.getContentPane().setLayout(null);
	        this.setResizable(false);
			this.add(PnlUtama);
			this.setLocation((dim.width / 2) - (getSize().width / 2), (dim.height / 2) - (getSize().height / 2));
			
			animasijln.setLocation(-527, 0);  

			flag = 0;
	        tmrAnimLabel = new Timer(10, AnimLabel); 
	        tmrAnimLabel.start();
		}
	
		public void MenuMenu(){
			PnlUtama	= new JLabel();
			PnlAtas		= new JLabel();
			PnlMenu		= new JLabel();
			PnlJdlMenu  = new JLabel();
			PnlOutput1	= new JLabel();
			PnlOutput2  = new JLabel();
			PnlBawah	= new JLabel();
			PnlLayar	= new JLabel();
			BtnSort		= new JLabel();
			BtnHitung	= new JLabel();
			BtnInput	= new JLabel();
			BtnClear	= new JLabel();
			BtnAbout	= new JLabel();
			BtnExit		= new JLabel();
			TxtInput 	= new JTextArea();
			TxtOutput	= new JTextArea();
			TxtMean		= new JTextField();
			TxtModus	= new JTextArea();
			TxtQ1		= new JTextField();
			TxtQ2		= new JTextField();
			TxtQ3		= new JTextField();
			LblInput	= new JLabel();
			LblOutput	= new JLabel();
			LblMean		= new JLabel();
			LblModus	= new JLabel();
			LblQ1		= new JLabel();
			LblQ2		= new JLabel();
			LblQ3		= new JLabel();
			animasijln	= new JLabel();
			// Ukuran
	
			PnlUtama.setLayout(null);
			PnlUtama.setBackground(Color.black);
			PnlUtama.setOpaque(true);
			PnlUtama.setBounds(0,0,527,350);
	
			PnlAtas.setBounds(0,0,527,30);
			PnlAtas.setBackground(Color.green);
			PnlAtas.setOpaque(true);
			PnlAtas.setLayout(null);
			PnlUtama.add(PnlAtas);
	
			PnlMenu.setBounds(0,50,100,300);
			PnlMenu.setBackground(Color.pink);
			PnlMenu.setOpaque(true);
			PnlMenu.setLayout(null);
			PnlUtama.add(PnlMenu);
	
			PnlJdlMenu.setBounds(0,30,100,20);
			PnlJdlMenu.setBackground(Color.blue);
			PnlJdlMenu.setOpaque(true);
			PnlJdlMenu.setLayout(null);
			PnlUtama.add(PnlJdlMenu);
	
			PnlLayar.setBounds(100,30,427,320);
			PnlLayar.setBackground(Color.magenta);
			PnlLayar.setOpaque(true);
			PnlLayar.setLayout(null);
			PnlUtama.add(PnlLayar);
	
			PnlOutput1.setBounds(20,100,170,130);
			PnlOutput1.setBackground(Color.yellow);
			PnlOutput1.setOpaque(true);
			PnlOutput1.setLayout(null);
			PnlLayar.add(PnlOutput1);
	
			PnlOutput2.setBounds(230,100,170,130);
			PnlOutput2.setBackground(Color.yellow);
			PnlOutput2.setOpaque(true);
			PnlOutput2.setLayout(null);
			PnlLayar.add(PnlOutput2);
			
			PnlBawah.setBounds(0,260,427,30);
			PnlBawah.setBackground(Color.black);
			PnlBawah.setOpaque(true);
			PnlBawah.setLayout(null);
			PnlLayar.add(PnlBawah);
	
			BtnInput.setBounds(10,10,80,20);
			BtnInput.setToolTipText("Klik Input");
			BtnInput.setBackground(Color.white);
			BtnInput.setForeground(Color.red);
			BtnInput.setOpaque(true);
			BtnInput.setText("Input");
			PnlMenu.add(BtnInput);
	
			BtnSort.setBounds(10,40,80,20);
			BtnSort.setToolTipText("Klik Sort");
			BtnSort.setBackground(Color.white);
			BtnSort.setForeground(Color.red);
			BtnSort.setOpaque(true);
			//BtnSort.setLabel("Sort");
			PnlMenu.add(BtnSort);
	
			BtnHitung.setBounds(10,70,80,20);
			BtnHitung.setToolTipText("Klik Hitung");
			BtnHitung.setBackground(Color.white);
			BtnHitung.setForeground(Color.red);
			BtnHitung.setOpaque(true);
			//BtnHitung.setLabel("Hitung");
			PnlMenu.add(BtnHitung);
			
			BtnClear.setBounds(10,100,80,20);
			BtnClear.setToolTipText("Klik Clear");
			BtnClear.setBackground(Color.white);
			BtnClear.setForeground(Color.red);
			BtnClear.setOpaque(true);
			//BtnClear.setLabel("Clear");
			PnlMenu.add(BtnClear);
			
			BtnAbout.setBounds(220,5,80,20);
			BtnAbout.setToolTipText("Klik About");
			BtnAbout.setBackground(Color.white);
			BtnAbout.setForeground(Color.red);
			BtnAbout.setOpaque(true);
			//BtnAbout.setLabel("About");
			PnlBawah.add(BtnAbout);
	
	
			BtnExit.setBounds(330,5,80,20);
			BtnExit.setToolTipText("Klik Exit");
			BtnExit.setBackground(Color.white);
			BtnExit.setForeground(Color.red);
			BtnExit.setOpaque(true);
			//BtnExit.setLabel("Exit");
			PnlBawah.add(BtnExit);
	
			LblInput.setBounds(20,30,100,20);
			LblInput.setBackground(Color.white);
			LblInput.setForeground(Color.red);
			LblInput.setOpaque(false);
			LblInput.setText("Masukan Angka");
			PnlLayar.add(LblInput);
	
			LblOutput.setBounds(20,60,105,20);
			LblOutput.setBackground(Color.white);
			LblOutput.setForeground(Color.red);
			LblOutput.setOpaque(false);
			LblOutput.setText("Setelah Diurutkan");
			PnlLayar.add(LblOutput);
	
			TxtInput.setBounds(130,30,270,20);
			TxtInput.setToolTipText(" Masukan Angka sesuai Data Stastistika");
			TxtInput.setBackground(Color.white);
			TxtInput.setForeground(Color.red);
			TxtInput.setOpaque(true);
			TxtInput.enable(false);
			TxtInput.setText("");
			PnlLayar.add(TxtInput);
	
			TxtOutput.setBounds(130,60,270,20);
			TxtOutput.setEnabled(false);
			TxtOutput.setBackground(Color.white);
			TxtOutput.setForeground(Color.red);
			TxtOutput.setOpaque(true);
			TxtOutput.setText("");
			PnlLayar.add(TxtOutput);
	
			LblMean.setBounds(20,30,30,20);
			LblMean.setBackground(Color.white);
			LblMean.setForeground(Color.red);
			LblMean.setOpaque(false);
			LblMean.setText("Me");
			PnlOutput1.add(LblMean);
	
			LblModus.setBounds(20,60,30,20);
			LblModus.setBackground(Color.white);
			LblModus.setForeground(Color.red);
			LblModus.setOpaque(false);
			LblModus.setText("Mo");
			PnlOutput1.add(LblModus);
	
			LblQ1.setBounds(20,30,30,20);
			LblQ1.setBackground(Color.white);
			LblQ1.setForeground(Color.red);
			LblQ1.setOpaque(false);
			LblQ1.setText("Q1");
			PnlOutput2.add(LblQ1);
	
			LblQ2.setBounds(20,60,30,20);
			LblQ2.setBackground(Color.white);
			LblQ2.setForeground(Color.red);
			LblQ2.setOpaque(false);
			LblQ2.setText("Q2");
			PnlOutput2.add(LblQ2);
	
			LblQ3.setBounds(20,90,30,20);
			LblQ3.setBackground(Color.white);
			LblQ3.setForeground(Color.red);
			LblQ3.setOpaque(false);
			LblQ3.setText("Q3");
			PnlOutput2.add(LblQ3);
	
			TxtMean.setBounds(50,30,100,20);
			TxtMean.setBackground(Color.white);
			TxtMean.setForeground(Color.red);
			TxtMean.setOpaque(true);
			TxtMean.setText("");
			PnlOutput1.add(TxtMean);
	
			TxtModus.setBounds(50,60,100,20);
			TxtModus.setBackground(Color.white);
			TxtModus.setForeground(Color.red);
			TxtModus.setOpaque(true);
			TxtModus.setText("");
			PnlOutput1.add(TxtModus);
	
			TxtQ1.setBounds(50,30,100,20);
			TxtQ1.setBackground(Color.white);
			TxtQ1.setForeground(Color.red);
			TxtQ1.setOpaque(true);
			TxtQ1.setText("");
			PnlOutput2.add(TxtQ1);
	
			TxtQ2.setBounds(50,60,100,20);
			TxtQ2.setBackground(Color.white);
			TxtQ2.setForeground(Color.red);
			TxtQ2.setOpaque(true);
			TxtQ2.setText("");
			PnlOutput2.add(TxtQ2);
	
			TxtQ3.setBounds(50,90,100,20);
			TxtQ3.setBackground(Color.white);
			TxtQ3.setForeground(Color.red);
			TxtQ3.setOpaque(true);
			TxtQ3.setText("");
			PnlOutput2.add(TxtQ3);
			
			animasijln.setText("Statistika");
			animasijln.setForeground(Color.blue);
	        animasijln.setFont(new Font("Avatar", 0, 32));
	        animasijln.setHorizontalTextPosition(JLabel.CENTER);
	        animasijln.setVerticalTextPosition(JLabel.CENTER);
	        animasijln.setHorizontalAlignment(JLabel.CENTER);
	        animasijln.setVerticalAlignment(JLabel.CENTER);
	        animasijln.setOpaque(false);
	        PnlAtas.add(animasijln);
	        animasijln.setBounds(250, 10, 400, 30);
	
			gambarControl();
			eventControl();
		}
		
		
		// Fungsi
		
		public void InputData(){
			String str = JOptionPane.showInputDialog("Masukkan jumlah data : ");
					jum = Integer.parseInt(str);
					
					for (i=0; i<jum; i++){
						String str2 = JOptionPane.showInputDialog("Masukkan data ke-" + (i+1) + ":");
						arrayInput[i] = Integer.parseInt(str2);
						TxtInput.append(str2 +" ");
					}		
		}
		
		public void ascending_BubleSort(int jum){
			int tmp = 0;
	
			for (int j = 0; j < jum; j++){
				for (int k = j+1; k < jum; k++){
					if (arrayInput[j] > arrayInput[k]){
						temp = arrayInput[j];
						arrayInput[j] = arrayInput[k];
						arrayInput[k] = temp;					   
					}
				}
			}
			
			for(int k = 0; k < jum; k++){
				TxtOutput.append(arrayInput[k] + " ");
			}
		}
		
		 private void hitungMean(){
			for(i=0; i<jum; i++){
				temp = temp + arrayInput[i];
			}
			
			rata2 = temp / jum;
			TxtMean.setText(rata2 + "");
		}
		
		private void hitungModus(){
			int lastEmpty = 1;
			int posx;
			
			for (i = 0; i <jum; i++) {
				posx = 0;
				for (j = 0; j <jum; j++) {
					if (arrayInput[i] == arrayModus[j][1]) {
						posx = j;
					}
				}
				
				if (posx != 0) {
					arrayModus[posx][2]++;
				} else {
					arrayModus[lastEmpty][1] = arrayInput[i];
					arrayModus[lastEmpty][2] = 1;
					lastEmpty++;
				}
			}
			
			int modus = 0;
			int banyak = 0;
			for (i = 0; i <jum; i++) {
				if (arrayModus[i][2] > banyak) {
					modus = arrayModus[i][1];
					banyak = arrayModus[i][2];
				}
			}
			
			TxtModus.setText(modus + "");
		}
		
		private void hitungQuartil(int jum){
			int indeksQ1 = 0, indeksQ2 = 0, indeksQ3 = 0;
			int Q1, Q2, Q3;
			
			if(jum % 2 != 0){
				indeksQ1=(jum/4);
                indeksQ2=(jum/2);
                indeksQ3=(3*jum/4);
				TxtQ1.setText(String.valueOf(arrayInput[indeksQ1]));
				TxtQ2.setText(String.valueOf(arrayInput[indeksQ2]));
				TxtQ3.setText(String.valueOf(arrayInput[indeksQ3]));
			} else {
				Q2=(arrayInput[jum/2]+arrayInput[(jum/2)-1])/2;
                Q1=(arrayInput[jum/4]+arrayInput[(jum/4)-1])/2;
                Q3=(arrayInput[(jum/2)+(jum/4)]+arrayInput[(jum/2)+(jum/4)+1])/2;
				TxtQ1.setText(String.valueOf(arrayInput[indeksQ1]));
				TxtQ2.setText(String.valueOf(arrayInput[indeksQ2]));
				TxtQ3.setText(String.valueOf(arrayInput[indeksQ3]));
			}
		}
		
		private void Hapus(){
			TxtInput.setText("");
			TxtOutput.setText("");
			TxtMean.setText("");
			TxtModus.setText("");
			TxtQ1.setText("");
			TxtQ2.setText("");
			TxtQ3.setText("");
		}
		
		// Control
		
		public void gambarControl(){
			gambar= new ImageIcon(getClass().getResource("/Images/input.png"));
			BtnInput.setIcon(gambar);
			gambar= new ImageIcon(getClass().getResource("/Images/sort.png"));
			BtnSort.setIcon(gambar);
			gambar= new ImageIcon(getClass().getResource("/Images/hitung.png"));
			BtnHitung.setIcon(gambar);
			gambar= new ImageIcon(getClass().getResource("/Images/cleare.png"));
			BtnClear.setIcon(gambar);
			gambar= new ImageIcon(getClass().getResource("/Images/about.png"));
			BtnAbout.setIcon(gambar);
			gambar= new ImageIcon(getClass().getResource("/Images/exit.png"));
			BtnExit.setIcon(gambar);
			
			
			
			gambar= new ImageIcon(getClass().getResource("/Images/atasnya.png"));
			PnlAtas.setIcon(gambar);
			//gambar= new ImageIcon(getClass().getResource("/Images/tampilan.png"));
			//PnlUtama.setIcon(gambar);
			gambar= new ImageIcon(getClass().getResource("/Images/panel.png"));
			PnlMenu.setIcon(gambar);
			gambar= new ImageIcon(getClass().getResource("/Images/menu.png"));
			PnlJdlMenu.setIcon(gambar);
			gambar= new ImageIcon(getClass().getResource("/Images/meee.png"));
			PnlOutput1.setIcon(gambar);
			gambar= new ImageIcon(getClass().getResource("/Images/qeeee.png"));
			PnlOutput2.setIcon(gambar);
			gambar= new ImageIcon(getClass().getResource("/Images/bawah.png"));
			PnlBawah.setIcon(gambar);
			gambar= new ImageIcon(getClass().getResource("/Images/panel masuk.png"));
			PnlLayar.setIcon(gambar);
		}
		 	
		public void eventControl() {
			
			BtnInput.addMouseListener(mosAdapter);
			BtnSort.addMouseListener(mosAdapter);
			BtnHitung.addMouseListener(mosAdapter);
			BtnClear.addMouseListener(mosAdapter);
			BtnAbout.addMouseListener(mosAdapter);
			BtnExit.addMouseListener(mosAdapter);
		}
		
		private ActionListener AnimLabel = new ActionListener() {
        int i = -150;

        @Override
        public void actionPerformed(ActionEvent e) {
            i++;  

            if(i == 150) i = -150; 

            
            if(i % 10 == 0) {  
                animasijln.setSize((animasijln.getWidth() == 0) ? 170 : 0, 30);  
            }
            animasijln.setLocation(i, 0);  
        }
    };
			
		//Action
				 
	    private MouseAdapter mosAdapter = new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent evt) {
	        	if(evt.getSource().equals(BtnInput)) {
					InputData();
				}else if(evt.getSource().equals(BtnSort)) {
					ascending_BubleSort(jum);
				}else if(evt.getSource().equals(BtnHitung)) {	
					hitungModus();
					hitungMean();
					hitungQuartil(jum);
				}else if(evt.getSource().equals(BtnClear)) {	
					Hapus();
				}else if(evt.getSource().equals(BtnAbout)) {	
					JOptionPane.showMessageDialog(null,"Final Projeck Pemrograman Lanjut,Oleh : \n 1. Jony Van NPA \n 2. Dewi Khoirur Rohmah \n 3. Rayi Dewanda \n 4. Rian Nurfalah \n 5. Hamron Triandoko","About",JOptionPane.INFORMATION_MESSAGE);
				}else if(evt.getSource().equals(BtnExit)) {	
					System.exit(0);
				}
	        }
	        
	        @Override
	        public void mousePressed(MouseEvent evt) {
	        		if(evt.getSource().equals(BtnInput)) {
						BtnInput.setIcon(new ImageIcon(getClass().getResource("/Images/hitung 2.png")));
					}else if(evt.getSource().equals(BtnSort)) {
						BtnSort.setIcon(new ImageIcon(getClass().getResource("/Images/sort 2.png")));
					}else if(evt.getSource().equals(BtnHitung)) {	
						BtnHitung.setIcon(new ImageIcon(getClass().getResource("/Images/hitung 2.png")));
					}else if(evt.getSource().equals(BtnClear)) {	
						BtnClear.setIcon(new ImageIcon(getClass().getResource("/Images/cleare 2.png")));
					}else if(evt.getSource().equals(BtnAbout)) {	
						BtnAbout.setIcon(new ImageIcon(getClass().getResource("/Images/about 2.png")));		
					}else if(evt.getSource().equals(BtnExit)) {	
						BtnExit.setIcon(new ImageIcon(getClass().getResource("/Images/exit 2.png")));
					}
	        }
	
	        @Override
	        public void mouseReleased(MouseEvent evt) {
	        		if(evt.getSource().equals(BtnInput)) {
						BtnInput.setIcon(new ImageIcon(getClass().getResource("/Images/input.png")));
					}else if(evt.getSource().equals(BtnSort)) {
						BtnSort.setIcon(new ImageIcon(getClass().getResource("/Images/sort.png")));
					}else if(evt.getSource().equals(BtnHitung)) {	
						BtnHitung.setIcon(new ImageIcon(getClass().getResource("/Images/hitung.png")));
					}else if(evt.getSource().equals(BtnClear)) {	
						BtnClear.setIcon(new ImageIcon(getClass().getResource("/Images/cleare.png")));
					}else if(evt.getSource().equals(BtnAbout)) {	
						BtnAbout.setIcon(new ImageIcon(getClass().getResource("/Images/about.png")));	
					}else if(evt.getSource().equals(BtnExit)) {	
						BtnExit.setIcon(new ImageIcon(getClass().getResource("/Images/exit.png")));
					}
	        }
	    
	};

    public static void main(String[] args) {
        Statistika S = new Statistika();
        S.setVisible(true);
    }
}
