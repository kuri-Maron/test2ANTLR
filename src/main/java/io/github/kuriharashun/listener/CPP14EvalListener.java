package io.github.kuriharashun.listener;

import io.github.kuriharashun.parsar.CPP14BaseListener;
import io.github.kuriharashun.parsar.CPP14Parser;

public class CPP14EvalListener extends CPP14BaseListener {

    private String className;

    @Override
    public void enterTranslationunit(CPP14Parser.TranslationunitContext ctx) {

    }

    public String getText() {
        return className;
    }
}
