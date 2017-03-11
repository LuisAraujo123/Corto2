/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.SeresVivos;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bernardo
 */
public class seresVivosCtrl {
    public boolean guar(SeresVivos obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("INSERT INTO seresvivos VALUES(NULL, ?, ?, ?)");
            cmd.setString(1, obje.getNomb_sere());
            cmd.setString(2, obje.getDesc_sere());
            cmd.setInt(3, obje.getCodi_refe_sere());
            cmd.executeUpdate();
            resp = true;
            
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        finally 
        {
            try 
            {
                if (cn!=null)
                {
                    if (!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return resp;
    }
    
    public boolean guar2(SeresVivos obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("INSERT INTO seresvivos VALUES(NULL, ?, ?, null)");
            cmd.setString(1, obje.getNomb_sere());
            cmd.setString(2, obje.getDesc_sere());
            cmd.executeUpdate();
            resp = true;
            
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        finally 
        {
            try 
            {
                if (cn!=null)
                {
                    if (!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return resp;
    }
    
    public boolean upda(SeresVivos obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("update seresvivos set nomb_sere = ?, desc_sere = ?, codi_refe_sere = ? where codi_sere = ?");
            cmd.setString(1, obje.getNomb_sere());
            cmd.setString(2, obje.getDesc_sere());
            cmd.setInt(3, obje.getCodi_refe_sere());
            cmd.setInt(4, obje.getCodi_sere());
            cmd.executeUpdate();
            resp = true;
            
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        finally 
        {
            try 
            {
                if (cn!=null)
                {
                    if (!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return resp;
    }
    
    public boolean upda2(SeresVivos obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("update seresvivos set nomb_sere = ?, desc_sere = ?, codi_refe_sere = null where codi_sere = ?");
            cmd.setString(1, obje.getNomb_sere());
            cmd.setString(2, obje.getDesc_sere());
            cmd.setInt(3, obje.getCodi_sere());
            cmd.executeUpdate();
            resp = true;
            
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        finally 
        {
            try 
            {
                if (cn!=null)
                {
                    if (!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return resp;
    }
    
    public boolean dele(SeresVivos obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("delete from seresvivos where codi_sere = ?");
            cmd.setInt(1, obje.getCodi_sere());
            cmd.executeUpdate();
            resp = true;
            
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        finally 
        {
            try 
            {
                if (cn!=null)
                {
                    if (!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return resp;
    }
    
    
    
    public List<SeresVivos> consTodo(){
        List<SeresVivos> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("SELECT s2.codi_sere, s2.codi_refe_sere, s2.nomb_sere, s2.desc_sere, s1.nomb_sere 'pertenece a' FROM seresvivos s1\n" +
                                                        "RIGHT JOIN seresvivos s2 on s1.codi_sere = s2.codi_refe_sere\n" +
                                                        "ORDER BY s1.codi_sere;");
            ResultSet rs = cmd.executeQuery();
            while (rs.next())
            {
                resp.add(new SeresVivos(rs.getInt(1), rs.getString(3),  rs.getString(4), rs.getInt(2), rs.getString(5)));  
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        finally 
        {
            try 
            {
                if (cn!=null)
                {
                    if (!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return resp;
    }
    
    public SeresVivos consUno(int id){
        SeresVivos resp = new SeresVivos();
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("Select * from seresvivos where codi_sere = ?;");
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();
            while (rs.next())
            {
                resp.setCodi_sere(rs.getInt(1));
                resp.setNomb_sere(rs.getString(2));
                resp.setDesc_sere(rs.getString(3));
                resp.setCodi_refe_sere(rs.getInt(4));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        finally 
        {
            try 
            {
                if (cn!=null)
                {
                    if (!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return resp;
    }
}
