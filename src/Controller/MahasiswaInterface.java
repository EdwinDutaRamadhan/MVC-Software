/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MahasiswaMod;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface MahasiswaInterface {
    public boolean insertMahasiswa(MahasiswaMod mhs);
    public boolean updateMahasiswa(MahasiswaMod mhs);
    public boolean deleteMahasiswa(MahasiswaMod mhs);
    public List<MahasiswaMod> getAll();
}
