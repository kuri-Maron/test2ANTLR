package io.github.kuriharashun.listener;

import io.github.kuriharashun.parsar.CPP14BaseListener;
import io.github.kuriharashun.parsar.CPP14Parser;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

public class CPP14EvalListener extends CPP14BaseListener {

    private String className;

    @Override
    public void enterTranslationunit(CPP14Parser.TranslationunitContext ctx) {
//ここに構文を追ってくコード書くんやで！多分
System.out.println(ctx);
    }

    @Override
        public void exitUnqualifiedid(CPP14Parser.UnqualifiedidContext ctx) {
            for(int i=0;i<ctx.getChildCount();i++) {
            if(ctx.getChild(i) instanceof TerminalNodeImpl) {
                className=ctx.getChild(0).getText();
            }
            }
        }

    //｛｝で囲まなくてもいいの？
    public String getText() {
        return className;
    }
}
