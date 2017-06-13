import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Run {
	JFrame p = new JFrame("Game Slide Puzzle");
	JMenuBar JMenubar = new JMenuBar();
		JMenu file = new JMenu("File");
			JMenu choimoi = new JMenu("Chơi mới");
				JMenuItem mucde = new JMenuItem("Mức dễ");
				JMenuItem mucvua = new JMenuItem("Mức vừa");
				JMenuItem muckho = new JMenuItem("Mức khó");
			JMenuItem thoat = new JMenuItem("Thoát game");
	
	public static void main(String[] args) {
		new Run();
	}
	
	public Run (){
		Broad();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void Broad(){
		p.setLayout(null);
		p.setVisible(true);
		p.setResizable(false);
		p.setSize(520, 450);
		p.setLocation(400, 150);
		
//		Sắp xếp giao diện
		this.JMenuBar();
	}
	
	protected void JMenuBar (){
//		Thêm các nút vào menu bar
		file.add(choimoi);
			choimoi.add(mucde);
			choimoi.add(mucvua);
			choimoi.add(muckho);
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
		thoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                thoatActionPerformed(evt);
            }
        });
		
	}
	
//	các hàm xử lý sự kiện
	public void mucdeActionPerformed(ActionEvent evt) {
		new MucDe();
		p.setVisible(false);
		p.removeAll();
    }
	
	public void mucvuaActionPerformed(ActionEvent evt) {
		new MucVua();
		p.setVisible(false);
		p.removeAll();
    }
	
	public void muckhoActionPerformed(ActionEvent evt) {
		new MucKho();
		p.setVisible(false);
		p.removeAll();
    }
	
//	chơi lại với hình mẫu màn trước
	public void choilaiActionPerformed(ActionEvent evt) {                                     
    }
	
//	thoát khỏi trò chơi
	public void thoatActionPerformed(ActionEvent evt) {                                     
        System.exit(0);
    }
}
