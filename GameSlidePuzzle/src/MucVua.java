import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class MucVua{
//	Tạo đối tượng
	JFrame p = new JFrame("Game Slide Puzzle (Mức vừa)");
	JMenuBar JMenubar = new JMenuBar();
		JMenu file = new JMenu("File");
			JMenu choimoi = new JMenu("Chơi mới");
				JMenuItem mucde = new JMenuItem("Mức dễ");
				JMenuItem mucvua = new JMenuItem("Mức vừa");
				JMenuItem muckho = new JMenuItem("Mức khó");
			JMenuItem choilai = new JMenuItem("Chơi lại");
			JMenuItem thoat = new JMenuItem("Thoát game");
	JPanel vungchoichinh = new JPanel();
	JButton Manh[] = new JButton[21];
	JLabel anhsosanh = new JLabel();
	JPanel trangthai = new JPanel();
	JLabel defaultsobuoc = new JLabel("Số bước ");
	JLabel sobuoc = new JLabel();
	int sb = 0;
	int vitri=20;
	int mangketqua[] = new int[21];
	JLabel anhgoc = new JLabel("");
	String hinhmau = new String("");
	
	public MucVua (){
		Broad();
		this.chonhinh();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//	Sắp xếp tạo giao diện
	public void Broad(){
		p.setLayout(null);
		p.setVisible(true);
		p.setResizable(false);
		p.setSize(620, 550);
		p.setLocation(300, 150);
		
//		Sắp xếp giao diện
		this.JMenuBar();
		this.MainJButton();
		this.CompareImage();
		this.status();
		
//		ẩn các vùng chơi chính, vùng ảnh so sánh và vùng trạng thái
		this.vungchoichinh.setVisible(false);
		this.anhgoc.setVisible(true);
		this.trangthai.setVisible(false);
	}
	
	protected void JMenuBar (){
//		Thêm các nút vào menu bar
		file.add(choimoi);
			choimoi.add(mucde);
			choimoi.add(mucvua);
			choimoi.add(muckho);
		file.add(choilai);
		file.addSeparator();
		file.add(thoat);
		
		p.setJMenuBar(JMenubar);
		JMenubar.add(file);
		
//		Xử lý sự kiện cho các nút trên menubar
		mucde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mucdeActionPerformed(evt);
            }
        });
		mucvua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mucvuaActionPerformed(evt);
            }
        });
		muckho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                muckhoActionPerformed(evt);
            }
        });
		choilai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                choilaiActionPerformed(evt);
            }
        });
		thoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                thoatActionPerformed(evt);
            }
        });
	}
	
	protected void MainJButton(){
//		Cài đặt vùng chơi chính
		vungchoichinh.setVisible(true);
		vungchoichinh.setLayout(null);
		vungchoichinh.setBounds(0, 0, 400, 500);
		int x=0,y=0;
		for (int i=1;i<=20;i++){
			Manh[i] = new JButton();
			vungchoichinh.add(Manh[i]);
			Manh[i].setBounds(x, y, 100, 100);
			if (i%4==0){
				x=0;
				y+=100;
			}
			else
				x+=100;
		}
		p.add(vungchoichinh);
		
//		Gắn sự kiện nút bấm cho các mảnh ghép ở vùng chơi chính
		this.gansukien();
	}
	
	protected void CompareImage(){
		anhsosanh.setBounds(420, 0, 180, 225);
		p.add(anhsosanh);
	}
	
	protected void OriginImage(){
		this.vungchoichinh.setVisible(false);
		this.anhgoc.setVisible(true);
		this.anhgoc.setBounds(0, 0, 400, 500);
		p.add(anhgoc);
		this.anhgoc.setIcon(new ImageIcon("images\\vua\\"+this.hinhmau+"\\goc.jpg"));
	}
	
	protected void status(){
		p.add(trangthai);
		trangthai.setBounds(420, 235, 180, 255);
		trangthai.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 255)));
		
		trangthai.add(defaultsobuoc);
		defaultsobuoc.setText("Số bước ");
		
		trangthai.add(sobuoc);
		sobuoc.setText("0");
	}
	
	private void gansukien(){
		//	gắn sự kiện nút bấm cho các mảnh
		Manh[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh1ActionPerformed(evt);
            }
        });
		
		Manh[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh2ActionPerformed(evt);
            }
        });
		
		Manh[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh3ActionPerformed(evt);
            }
        });
		
		Manh[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh4ActionPerformed(evt);
            }
        });
		
		Manh[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh5ActionPerformed(evt);
            }
        });
		
		Manh[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh6ActionPerformed(evt);
            }
        });
		
		Manh[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh7ActionPerformed(evt);
            }
        });
		
		Manh[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh8ActionPerformed(evt);
            }
        });
		
		Manh[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh9ActionPerformed(evt);
            }
        });
		
		Manh[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh10ActionPerformed(evt);
            }
        });
		
		Manh[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh11ActionPerformed(evt);
            }
        });
		
		Manh[12].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh12ActionPerformed(evt);
            }
        });
		
		Manh[13].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh13ActionPerformed(evt);
            }
        });
		
		Manh[14].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh14ActionPerformed(evt);
            }
        });
		
		Manh[15].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh15ActionPerformed(evt);
            }
        });
		
		Manh[16].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh16ActionPerformed(evt);
            }
        });
		
		Manh[17].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh17ActionPerformed(evt);
            }
        });
		
		Manh[18].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh18ActionPerformed(evt);
            }
        });
		
		Manh[19].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh19ActionPerformed(evt);
            }
        });
		
		Manh[20].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manh20ActionPerformed(evt);
            }
        });
	}
	
//	gắn hình ảnh vào JLabel và JButton
	protected void anhxep(){
		for (int i=1;i<=19;i++)
			Manh[i].setIcon(new ImageIcon("images\\vua\\"+this.hinhmau+"\\("+i+").jpg"));
		Manh[20].setIcon(null);
	}
	
	
//	Hàm bắt đầu trò chơi
	private void batdautrochoi(){
		this.vitri = 20;
//		Cài hình
		this.anhxep();
		anhsosanh.setIcon(new ImageIcon("images\\vua\\"+this.hinhmau+"\\sosanh.jpg"));

//		cho hiện vùng chơi chính thay vì hiện hình ảnh gốc
		this.vungchoichinh.setVisible(true);
		this.anhgoc.setVisible(false);
		this.trangthai.setVisible(true);
		
//		Các thao tác chuẩn bị để chơi (bao gồm việc chuẩn bị mảng lưu vị trí các mảnh, xáo trộn các mảnh ghép với nhau, đặt lại số bước di chuyển về 0)
		for (int i=1;i<=20;i++)
			this.mangketqua[i] = i;
		
		this.xaotron();
		this.sb=0;
		this.sobuoc.setText("0");
	}

	//	các hàm xử lý sự kiện
	public void mucdeActionPerformed(ActionEvent evt) {
		new MucDe();
		p.setVisible(false);
		p.removeAll();
    }
	
	public void mucvuaActionPerformed(ActionEvent evt) {
		this.chonhinh();
		this.batdautrochoi();
    }
	
	public void muckhoActionPerformed(ActionEvent evt) {
		new MucKho();
		p.setVisible(false);
		p.removeAll();
    }
	
//	chơi lại với hình mẫu màn trước
	public void choilaiActionPerformed(ActionEvent evt) {                                     
		this.chonhinh();
		this.batdautrochoi();
	}
	
//	thoát khỏi trò chơi
	public void thoatActionPerformed(ActionEvent evt) {                                     
        System.exit(0);
    }
	
	
	
//	Xử lý đối với các mảnh
	private void manh1ActionPerformed(ActionEvent evt){
		if (vitri == 5 || vitri == 2){
			this.swap(mangketqua, vitri, 1);
			this.chuyenmanh(Manh[1], Manh[vitri]);
			this.vitri = 1;
			
		}
		this.ketthuc();
	}

	private void manh2ActionPerformed(ActionEvent evt){
		if (vitri == 6 || vitri == 3 || vitri == 1){
			this.swap(mangketqua, vitri, 2);
			this.chuyenmanh(Manh[2], Manh[vitri]);
			this.vitri = 2;
		}
		this.ketthuc();
	}

	private void manh3ActionPerformed(ActionEvent evt){
		if (vitri == 7 || vitri == 2 || vitri == 4){
			this.swap(mangketqua, vitri, 3);
			this.chuyenmanh(Manh[3], Manh[vitri]);
			this.vitri = 3;
		}
		this.ketthuc();
	}

	private void manh4ActionPerformed(ActionEvent evt){
		if (vitri == 8 || vitri == 3){
			this.swap(mangketqua, vitri, 4);
			this.chuyenmanh(Manh[4], Manh[vitri]);
			this.vitri = 4;
		}
		this.ketthuc();
	}

	private void manh5ActionPerformed(ActionEvent evt){
		if (vitri == 1 || vitri == 6 || vitri == 9){
			this.swap(mangketqua, vitri, 5);
			this.chuyenmanh(Manh[5], Manh[vitri]);
			this.vitri = 5;
		}
		this.ketthuc();
	}

	private void manh6ActionPerformed(ActionEvent evt){
		if (vitri == 2 || vitri == 5 || vitri == 7 || vitri == 10){
			this.swap(mangketqua, vitri, 6);
			this.chuyenmanh(Manh[6], Manh[vitri]);
			this.vitri = 6;
		}
		this.ketthuc();
	}

	private void manh7ActionPerformed(ActionEvent evt){
		if (vitri == 3 || vitri == 6 || vitri == 8 || vitri == 11 ){
			this.swap(mangketqua, vitri, 7);
			this.chuyenmanh(Manh[7], Manh[vitri]);
			this.vitri = 7;
		}
		this.ketthuc();
	}

	private void manh8ActionPerformed(ActionEvent evt){
		if (vitri == 4 || vitri == 7 || vitri == 12){
			this.swap(mangketqua, vitri, 8);
			this.chuyenmanh(Manh[8], Manh[vitri]);
			this.vitri = 8;
		}
		this.ketthuc();
	}

	private void manh9ActionPerformed(ActionEvent evt){
		if (vitri == 5 || vitri == 10 || vitri == 13){
			this.swap(mangketqua, vitri, 9);
			this.chuyenmanh(Manh[9], Manh[vitri]);
			this.vitri = 9;
		}
		this.ketthuc();
	}

	private void manh10ActionPerformed(ActionEvent evt){
		if (vitri == 6 || vitri == 9 || vitri == 11 || vitri == 14){
			this.swap(mangketqua, vitri, 10);
			this.chuyenmanh(Manh[10], Manh[vitri]);
			this.vitri = 10;
		}
		this.ketthuc();
	}

	private void manh11ActionPerformed(ActionEvent evt){
		if (vitri == 7 || vitri == 10 || vitri ==12 || vitri == 15){
			this.swap(mangketqua, vitri, 11);
			this.chuyenmanh(Manh[11], Manh[vitri]);
			this.vitri = 11;
		}
		this.ketthuc();
	}

	private void manh12ActionPerformed(ActionEvent evt){
		if (vitri == 8 || vitri == 11 ||  vitri == 16){
			this.swap(mangketqua, vitri, 12);
			this.chuyenmanh(Manh[12], Manh[vitri]);
			this.vitri = 12;
		}
		this.ketthuc();
	}

	private void manh13ActionPerformed(ActionEvent evt){
		if (vitri == 9 || vitri == 14 || vitri == 17){
			this.swap(mangketqua, vitri, 13);
			this.chuyenmanh(Manh[13], Manh[vitri]);
			this.vitri = 13;
		}
		this.ketthuc();
	}

	private void manh14ActionPerformed(ActionEvent evt){
		if (vitri == 10 || vitri == 13 || vitri == 15 || vitri == 18){
			this.swap(mangketqua, vitri, 14);
			this.chuyenmanh(Manh[14], Manh[vitri]);
			this.vitri = 14;
		}
		this.ketthuc();
	}

	private void manh15ActionPerformed(ActionEvent evt){
		if (vitri == 11 || vitri == 14 || vitri == 16 || vitri == 19){
			this.swap(mangketqua, vitri, 15);
			this.chuyenmanh(Manh[15], Manh[vitri]);
			this.vitri = 15;
		}
		this.ketthuc();
	}

	private void manh16ActionPerformed(ActionEvent evt){
		if (vitri == 12 || vitri == 15 || vitri == 20){
			this.swap(mangketqua, vitri, 16);
			this.chuyenmanh(Manh[16], Manh[vitri]);
			this.vitri = 16;
		}
		this.ketthuc();
	}

	private void manh17ActionPerformed(ActionEvent evt){
		if (vitri == 13 || vitri == 18){
			this.swap(mangketqua, vitri, 17);
			this.chuyenmanh(Manh[17], Manh[vitri]);
			this.vitri = 17;
		}
		this.ketthuc();
	}

	private void manh18ActionPerformed(ActionEvent evt){
		if (vitri == 14 || vitri == 17 || vitri == 19){
			this.swap(mangketqua, vitri, 18);
			this.chuyenmanh(Manh[18], Manh[vitri]);
			this.vitri = 18;
		}
		this.ketthuc();
	}

	private void manh19ActionPerformed(ActionEvent evt){
		if (vitri == 15 || vitri == 18 || vitri == 20){
			this.swap(mangketqua, vitri, 19);
			this.chuyenmanh(Manh[19], Manh[vitri]);
			this.vitri = 19;
		}
		this.ketthuc();
	}

	private void manh20ActionPerformed(ActionEvent evt){
		if (vitri == 16 || vitri == 19){
			this.swap(mangketqua, vitri, 20);
			this.chuyenmanh(Manh[20], Manh[vitri]);
			this.vitri = 20;
		}
		this.ketthuc();
	}
	
//	Các thao tác trong trò chơi
//	chuyển vị hai mảnh (chuyển mảnh 1 thế chỗ vào mảnh 2 và sau đó để trống mảnh 1)
	private void chuyenmanh(JButton Manh1, JButton Manh2){
		Manh2.setIcon(Manh1.getIcon());
		Manh1.setIcon(null);
		sb++;
		sobuoc.setText(""+sb);
	}
	
//	Xử lý việc chuyển mảnh theo hướng
	private void chuyenlentren()
	{
		if (vitri<=16)
		{
			int vitrimoi = this.vitri+4;
			this.swap(mangketqua, vitri, vitrimoi);
			this.chuyenmanh(Manh[vitrimoi], Manh[vitri]);
			this.vitri=vitrimoi;
		}
	}
	
	private void chuyenxuongduoi()
	{
		if (vitri>=5)
		{
			int vitrimoi = vitri-4;
			this.swap(mangketqua, vitri, vitrimoi);
			this.chuyenmanh(Manh[vitrimoi], Manh[vitri]);
			this.vitri=vitrimoi;
		}
	}
	
	private void chuyensangtrai()
	{
		if (vitri%4!=0)
		{
			int vitrimoi = vitri+1;
			this.swap(mangketqua, vitri, vitrimoi);
			this.chuyenmanh(Manh[vitrimoi], Manh[vitri]);
			this.vitri=vitrimoi;
		}
	}
	
	private void chuyensangphai()
	{
		if (vitri%4!=1)
		{
			int vitrimoi = vitri-1;
			this.swap(mangketqua, vitri, vitrimoi);
			this.chuyenmanh(Manh[vitrimoi], Manh[vitri]);
			this.vitri=vitrimoi;
		}
	}
	
	
//	Hàm xếp trộn các mảnh
	private void xaotron()
	{
		Random ran = new Random();
		int huong, huongcu = 0;
		
		while (this.kttrangthai() < 20)
		{
			//	tạo ngẫu nhiên hướng di chuyển của mảnh (sao cho không lặp lại trạng thái liền trước đó)
			do
			{
				huong = 1+ ran.nextInt(4);
			}
			while (this.ktlaplaibuocdi(huong, huongcu));
			
			//	xáo trộn các mảnh theo hướng ngẫu nhiên
			switch(huong)
			{
			case 1:
				this.chuyenlentren();
				break;
			case 2:
				this.chuyenxuongduoi();
				break;
			case 3:
				this.chuyensangtrai();
				break;
			case 4:
				this.chuyensangphai();
				break;
			default:
				break;
			}
			
			huongcu = huong;
		}
	}
	
	private boolean ktlaplaibuocdi(int huongmoi, int huongcu)
	{
		switch(huongmoi)
		{
			case 1:
				if (huongcu == 2)
					return true;
				break;
			case 2:
				if (huongcu == 1)
					return true;
				break;
			case 3:
				if (huongcu == 4)
					return true;
				break;
			case 4:
				if (huongcu == 3)
					return true;
				break;
			default:
				break;
		}
		return false;
	}
	
	private int kttrangthai()
	{
		int sophantusailech=0;
		
		for (int i=1;i<=20;i++)
			if (this.mangketqua[i]!=i)
				sophantusailech++;
		return sophantusailech;
	}
	
	private void swap (int Mang[], int vitri1, int vitri2)
	{
		int BienTam = Mang[vitri1];
		Mang[vitri1] = Mang[vitri2];
		Mang[vitri2] = BienTam;
		
//		System.out.println("chuyển mảnh: "+vitri2+"| "+vitri1);
	}
	
	
//	Kết thúc! đưa ra điều kiện thắng trò chơi
	private void ketthuc ()
	{
		if (this.kttrangthai() == 0)
		{
//			Xử lý khi kết thúc (người chơi chiến thắng)
			this.chienthang();
			this.OriginImage();
		}
	}
	/*Kết thúc frame chính*/
	
	
	
	
	/*Tạo Frame chọn hình cho việc chơi mới*/
//	Khai báo các đối tượng
	JFrame c = new JFrame("Chọn hình");
	JLabel yeucau = new JLabel("Mời bạn chọn 1 hình bất kì để bắt đầu trò chơi");
	JButton mau[] = new JButton[9];
	
//	tạo frame
	public void chonhinh (){
		thongbaochonhinh();
		c.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
//	Sắp xếp các đối tượng trên frame
	public void thongbaochonhinh(){
		c.setSize(640, 500);
		c.setLocation(400, 150);
		c.setVisible(true);
		c.setLayout(null);
		c.setResizable(false);
		
//		In ra thông báo
		c.add(yeucau);
		this.yeucau.setBounds(0, 10, 400, 20);
		
//		thêm các nút hình ảnh vào frame
		this.sapxep();
		for (int i=1;i<=8;i++)
			c.add(mau[i]);
		
//		ghép hình ảnh vào các nút bấm
		this.ganhinhanhmau();
		
//		thêm sự kiện nhấn chuột cho các nút hình
		this.gansukienhinhmau();
	}
	

//	Sắp xếp các nút hình ảnh
	private void sapxep(){
		int x=0,y=50;
		for (int i=1;i<=4;i++){
			mau[i] = new JButton();
			mau[i].setBounds(x, y, 160, 200);
			x+=160;
		}
		x=0;y=250;
		for (int i=5;i<=8;i++){
			mau[i] = new JButton();
			mau[i].setBounds(x, y, 160, 200);
			x+=160;
		}
		
	}
	
	
//	Gắn hình ảnh
	private void ganhinhanhmau(){
		for (int i=1;i<=8;i++)
			mau[i].setIcon(new ImageIcon("images\\vua\\Mau"+i+".jpg"));
	}

	
//	Gắn sự kiện
	private void gansukienhinhmau(){
		mau[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mau1ActionPerformed(evt);
            }
        });
		
		mau[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mau2ActionPerformed(evt);
            }
        });
		
		mau[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mau3ActionPerformed(evt);
            }
        });
		
		mau[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mau4ActionPerformed(evt);
            }
        });
		
		mau[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mau5ActionPerformed(evt);
            }
        });
		
		mau[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mau6ActionPerformed(evt);
            }
        });
		
		mau[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mau7ActionPerformed(evt);
            }
        });
		
		mau[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mau8ActionPerformed(evt);
            }
        });
	}
	
	
//	Xử lý sự kiện nhấn nút
	private void mau1ActionPerformed(ActionEvent evt){
		this.hinhmau = "Mau1";
		c.setVisible(false);
		this.batdautrochoi();
	};

	private void mau2ActionPerformed(ActionEvent evt){
		this.hinhmau = "Mau2";
		c.setVisible(false);
		this.batdautrochoi();
	};

	private void mau3ActionPerformed(ActionEvent evt){
		this.hinhmau = "Mau3";
		c.setVisible(false);
		this.batdautrochoi();
	};

	private void mau4ActionPerformed(ActionEvent evt){
		this.hinhmau = "Mau4";
		c.setVisible(false);
		this.batdautrochoi();
	};

	private void mau5ActionPerformed(ActionEvent evt){
		this.hinhmau = "Mau5";
		c.setVisible(false);
		this.batdautrochoi();
	};

	private void mau6ActionPerformed(ActionEvent evt){
		this.hinhmau = "Mau6";
		c.setVisible(false);
		this.batdautrochoi();
	};

	private void mau7ActionPerformed(ActionEvent evt){
		this.hinhmau = "Mau7";
		c.setVisible(false);
		this.batdautrochoi();
	};

	private void mau8ActionPerformed(ActionEvent evt){
		this.hinhmau = "Mau8";
		c.setVisible(false);
		this.batdautrochoi();
	};
	/*Kết thúc việc chọn hình*/
	
	
	
	/*Tạo frame hiển thị khi người chơi chiến thắng*/
	JFrame w = new JFrame("Kết quả");
	JLabel winner = new JLabel("Bạn đã chiến thắng trò chơi");
	JButton wchoitiep = new JButton("Chơi tiếp mức khó");
	JButton wchoilai = new JButton("Chơi lại");
	JButton wthoat = new JButton("Kết thúc");
	
	public void chienthang (){
		thongbaochienthang();
		w.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public void thongbaochienthang(){
		w.setSize(420, 120);
		w.setLocation(300, 200);
		w.setVisible(true);
		w.setLayout(null);
		w.setResizable(false);
		
//		In ra thông báo
		w.add(winner);
		winner.setBounds(70, 10, 200, 20);
		
//		Thêm các nút và xử lý xự kiện trên các nút
		w.add(wchoitiep);
		wchoitiep.setBounds(30, 50, 150, 30);
		wchoitiep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	wchoitiepActionPerformed(evt);
            }
        });
		
		w.add(wchoilai);
		wchoilai.setBounds(200, 50, 100, 30);
		wchoilai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                wchoilaiActionPerformed(evt);
            }
        });
		
		w.add(wthoat);
		wthoat.setBounds(300, 50, 100, 30);
		wthoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                thoatActionPerformed(evt);
            }
        });
	}
	
	public void wchoitiepActionPerformed(ActionEvent evt) {
		new MucKho();
		p.setVisible(false);
		p.removeAll();
		w.setVisible(false);
    }
	public void wchoilaiActionPerformed(ActionEvent evt) {                                     
		this.chonhinh();
		this.batdautrochoi();
		w.setVisible(false);
	}
	/*Kết thúc frame hiển thị khi người chơi chiến thắng*/
}
