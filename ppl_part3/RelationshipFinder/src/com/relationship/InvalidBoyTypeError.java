/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

/**
 *
 * @author Rishabh Rishu
 */
public class InvalidBoyTypeError extends Exception{
    /**
     * 
     * @param msg pass message to throwable
     */
    public InvalidBoyTypeError(String msg){
        super(msg);
    }
}
