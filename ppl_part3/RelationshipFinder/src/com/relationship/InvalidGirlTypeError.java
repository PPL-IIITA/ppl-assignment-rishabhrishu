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
public class InvalidGirlTypeError extends Exception{
    /**
     * 
     * @param msg message to pass to throwable
     */
    public InvalidGirlTypeError(String msg){
        super(msg);
    }
}
