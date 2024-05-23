package com.example.miravereda.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

/**
 * Una barra de progreso personalizada que puede centrarse fácilmente dentro de un ViewGroup
 * y puede mostrarse u ocultarse junto con otras vistas dentro del ViewGroup.
 */
public class MyProgressBar extends ProgressBar {

    private ViewGroup rootView;

    /**
     * Constructor para crear un MyProgressBar con el contexto especificado.
     *
     * @param context el contexto a usar
     */
    public MyProgressBar(Context context) {
        super(context);
    }

    /**
     * Constructor para crear un MyProgressBar con el contexto y conjunto de atributos especificados.
     *
     * @param context el contexto a usar
     * @param attrs el conjunto de atributos a usar
     */
    public MyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Constructor para crear un MyProgressBar con el contexto, conjunto de atributos y
     * atributo de estilo predeterminado especificados.
     *
     * @param context el contexto a usar
     * @param attrs el conjunto de atributos a usar
     * @param defStyleAttr el atributo de estilo predeterminado a usar
     */
    public MyProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Inicializa el MyProgressBar con el rootView especificado y lo centra.
     *
     * @param rootView el ViewGroup a usar como vista raíz
     */
    public void initControl(ViewGroup rootView){
        this.rootView = rootView;
        center();
        this.rootView.addView(this);
    }

    /**
     * Muestra el MyProgressBar y oculta todas las demás vistas en el rootView.
     */
    public void show() {
        for (int i = 0; i < rootView.getChildCount(); i++) {
            View child = rootView.getChildAt(i);
            if (!child.equals(this))
                child.setVisibility(View.GONE);
            else
                child.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Oculta el MyProgressBar y muestra todas las demás vistas en el rootView.
     */
    public void hide() {
        for (int i = 0; i < rootView.getChildCount(); i++) {
            View child = rootView.getChildAt(i);
            if (!child.equals(this))
                child.setVisibility(View.VISIBLE);
            else
                child.setVisibility(View.GONE);
        }
    }

    /**
     * Centra el MyProgressBar dentro del rootView. Soporta ConstraintLayout y RelativeLayout.
     */
    public void center() {
        if (rootView instanceof ConstraintLayout) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.bottomToBottom = ConstraintSet.PARENT_ID;
            layoutParams.endToEnd = ConstraintSet.PARENT_ID;
            layoutParams.startToStart = ConstraintSet.PARENT_ID;
            layoutParams.topToTop = ConstraintSet.PARENT_ID;
            this.setLayoutParams(layoutParams);
        } else if (rootView instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
            this.setLayoutParams(layoutParams);
        }
    }
}
