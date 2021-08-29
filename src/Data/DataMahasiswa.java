/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Connection.Myconnection;
import Controller.MahasiswaInterface;
import Model.MahasiswaMod;
import com.mysql.jdbc.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class DataMahasiswa implements MahasiswaInterface {
    private Connection koneksi = null;
    MahasiswaMod mhs;

    public DataMahasiswa() {
        this.koneksi = new Myconnection().getConnection();
    }
    
    /**
     *
     * @param mhs
     * @return
     */
    @Override
    public boolean insertMahasiswa(MahasiswaMod mhs) {
      boolean result = false;
      
      try{
          PreparedStatement ps = koneksi.prepareStatement("INSERT INTO mahasiswa"
          + " VALUES (?,?,?,?,?,?,?)");
          ps.setString(1, mhs.getKodeSurat());
          ps.setString(2, mhs.getLampiran());
          ps.setString(3, mhs.getTanggalSurat());
          ps.setString(4, mhs.getJenisSurat());
          ps.setString(5, mhs.getPerihal());
          ps.setString(6, mhs.getPenanggungJawab());
          ps.setString(7, mhs.getJabatan());
          ps.executeUpdate();
          result = true;
      }catch(SQLException e){
          System.out.println("An Error \n" +e.getMessage());
      }
      return result;
    }

    @Override
    public boolean updateMahasiswa(MahasiswaMod mhs) {
      boolean result = false;
      
      try{
          PreparedStatement ps = koneksi.prepareStatement("UPDATE mahasiswa SET"  
                  + " Jabatan=?, Lampiran=?, TanggalSurat=?, JenisSurat=?, Perihal=?, PenanggungJawab=?" 
                  + " WHERE KodeSurat=?");
          ps.setString(1, mhs.getJabatan());
          ps.setString(2, mhs.getLampiran());
          ps.setString(3, mhs.getTanggalSurat());
          ps.setString(4, mhs.getJenisSurat());
          ps.setString(5, mhs.getPerihal());
          ps.setString(6, mhs.getPenanggungJawab());
          ps.setString(7, mhs.getKodeSurat());
          ps.executeUpdate();
          result = true;
      }catch(SQLException e){
          System.out.println("An Error \n" +e.getMessage());
      }
      return result;
    }
    public boolean cariMahasiswa(MahasiswaMod mhs) {
      boolean result = false;
      
      try{
          PreparedStatement ps = koneksi.prepareStatement("UPDATE mahasiswa SET"  
                  + " Jabatan=?, Lampiran=?, TanggalSurat=?, JenisSurat=?, Perihal=?, PenanggungJawab=?" 
                  + " WHERE KodeSurat=?");
          ps.setString(1, mhs.getJabatan());
          ps.setString(2, mhs.getLampiran());
          ps.setString(3, mhs.getTanggalSurat());
          ps.setString(4, mhs.getJenisSurat());
          ps.setString(5, mhs.getPerihal());
          ps.setString(6, mhs.getPenanggungJawab());
          ps.setString(7, mhs.getKodeSurat());
          ps.executeUpdate();
          result = true;
          /*
          DefaultTableModel tabelData = new DefaultTableModel();
        tabelData.addColumn("kodeSurat");
        tabelData.addColumn("lampiran");
        tabelData.addColumn("tanggalSurat");
        tabelData.addColumn("jenisSurat");
        tabelData.addColumn("perihal");
        tabelData.addColumn("penanggungJawab");
        tabelData.addColumn("jabatan");
        
        try{
            Connection koneksi = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/kbm_mahasiswa","root", "");
            koneksi.createStatement().executeUpdate("Select * from mahasiswa where kodesurat like '%" + kodesuratText.getText() +"%'" + "or lampiran like '%" +lampiranText.getText()+ "%'" + "or tanggalsurat like '%" + tanggalsuratText.getText()+ "%'" + "or jenissurat like '%" + jenissuratText.getText()+ "%'" + "or perihal like '%" +perihalText.getText()+ "%'" + "or penanggungjawab like '%" +penanggungjawabText.getText()+ "%'"+ "or jabatan like '%" + jabatanText.getSelectedItem()+ "%'" );
               
        }catch(Exception e){
            
        }
          */
      }catch(SQLException e){
          System.out.println("An Error \n" +e.getMessage());
      }
      return result;
    }

    @Override
    public boolean deleteMahasiswa(MahasiswaMod mhs) {
        boolean result = false;
        try{
            PreparedStatement ps = koneksi.prepareStatement("DELETE FROM mahasiswa" + " WHERE KodeSurat=?");
            ps.setString(1, mhs.getKodeSurat());
            ps.executeUpdate();
            result = true;
        }catch(SQLException e){
            System.out.println("An Error \n" +e.getMessage());
        }
        
        return result;
    }
    public boolean cariPenanggungJawab(MahasiswaMod mhs) {
        boolean result = false;
        try{
            PreparedStatement ps = koneksi.prepareStatement("select * from mahasiswa where PenanggungJawab=?");
            ps.setString(6, mhs.getPenanggungJawab());
            ps.executeUpdate();
            result = true;
        }catch(SQLException e){
            System.out.println("An Error \n" +e.getMessage());
        }
        
        return result;
    }


    @Override
    public List<MahasiswaMod> getAll() {
        List<MahasiswaMod> ls = new ArrayList<>();
        
        try {
            PreparedStatement ps = koneksi.prepareStatement("SELECT * FROM mahasiswa");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                mhs = new MahasiswaMod();
                mhs.setKodeSurat(rs.getString(1));
                mhs.setLampiran(rs.getString(2));
                mhs.setTanggalSurat(rs.getString(3));
                mhs.setJenisSurat(rs.getString(4));
                mhs.setPerihal(rs.getString(5));
                mhs.setPenanggungJawab(rs.getString(6));
                mhs.setJabatan(rs.getString(7));
                ls.add(mhs); 
            }
        } catch (Exception e) {
            System.out.println("An Error :"+e.getMessage());
        }
        return ls;
    }
   
}
