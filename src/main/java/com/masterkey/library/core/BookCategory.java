/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterkey.library.core;

/**
 *
 * @author francesco
 */
public enum BookCategory {
    ADVENTURE,
    THRILLER,
    SCI_FI,
	NULL;
    
    public String getCategory(){
        switch(this){
            case ADVENTURE:
                return "adventure";
            case THRILLER:
                return "thriller";
            case SCI_FI:
                return "sci-fi";
            default:
                return "null";
        }
    }
}
