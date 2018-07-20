package io.github.kuriharashun.listener;

import io.github.kuriharashun.parsar.CPP14Lexer;
import io.github.kuriharashun.parsar.CPP14Parser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CPP14EvalListenerTest {

    CPP14EvalListener obj = new CPP14EvalListener();
    CPP14Lexer lexer;
    CommonTokenStream tokens;
    CPP14Parser parsar;
    ParseTree tree;
    ParseTreeWalker walker;

    @Test
    void クラス名を取得する() {
        init("class ClassName {}");
        String expected = "ClassName";

        String actual = obj.getText();

        assertThat(actual).isEqualTo(expected);
    }

    private void init(String code) {
        lexer = new CPP14Lexer(CharStreams.fromString(code));
        tokens = new CommonTokenStream(lexer);
        parsar = new CPP14Parser(tokens);
        tree = parsar.translationunit();
        walker = new ParseTreeWalker();
        obj = new CPP14EvalListener();
        walker.walk(obj, tree);
    }
}