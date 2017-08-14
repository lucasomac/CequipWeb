/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author lomacedo
 * @param <T>
 */
public interface DAO<T> {

    public T getSingle(Object... chave);

    public List<T> getList();

    public List<T> getList(int top);
}