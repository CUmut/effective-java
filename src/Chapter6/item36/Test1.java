package Chapter6.item36;

import java.util.EnumSet;

public class Test1 {

	public static void main(String[] args) {
		Text2 text = new Text2();

		text.applyStyles(EnumSet.of(Text2.Style.BOLD, Text2.Style.ITALIC));
	}

}
