import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ComboAgent extends KeyAdapter {
		JTextField editor;
		JComboBox combo;
		
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