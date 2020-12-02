import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Browser extends JFrame
{
    private String[] list = {"Timeking", "Manghon", "timemanghon"};
    private JComboBox box;
       
    public Browser()
    {
        super("HTML Browser");
        setSize(500, 300);
   
        box = new JComboBox(list);
        box.setEditable(true);
        add("North", box);
       
        ComboAgent agent = new ComboAgent(box);
       
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
   
    class ComboAgent extends KeyAdapter
    {
        JComboBox combo;
        JTextField editor;
       
        public ComboAgent(JComboBox box)
        {
            combo = box;
            editor = (JTextField)combo.getEditor().getEditorComponent();
            editor.addKeyListener(this);
        }
       
        public void keyReleased(KeyEvent e)
        {
            char ch = e.getKeyChar();
           
            if(ch == KeyEvent.CHAR_UNDEFINED || Character.isISOControl(ch))
                return;
           
            int pos = editor.getCaretPosition();
            String str = editor.getText();
           
            if(str.length() == 0)
                return;
           
            for(int k=0; k<combo.getItemCount(); k++)
            {
                String iteml = combo.getItemAt(k).toString().toLowerCase();
                String item = combo.getItemAt(k).toString();
                // ���� ��.. �Է��� ���ڿ��� ����Ʈ�� �ִ� �������� ù�Ӹ��� ��ġ�ϴ���..
                if( item.startsWith(str) || iteml.startsWith(str) ||
                    item.startsWith(str.toLowerCase()) ||
                    iteml.startsWith(str.toLowerCase()) )
                {
                    // ��ġ�Ѵٸ� field�� ��ġ�� �������� �����ϰ�
                    // �ڵ����� �ϼ��� �κ��� ����ǥ�÷� �Ͽ� �����Ѵ�.
                    editor.setText(item);   
                    editor.setCaretPosition(item.length());
                    editor.moveCaretPosition(pos);   
                    break;
                }
            }
        }
    }
   
    public static void main(String[] args)
    {
        new Browser();
    }
}