package com.krav.att.attendance_teacher.Shared;

import android.content.Context;
import android.content.SharedPreferences;

import com.krav.att.attendance_teacher.Util.Util;

import org.joda.time.LocalDate;

public class UserDataShared {

	private String codCustomer, codGender, phone, name, email, passwordSHA256;
	private LocalDate bornDate;

	private static UserDataShared instance;

	private UserDataShared() {}

	public String getPasswordSHA256() {
		return passwordSHA256;
	}

	public void setPasswordSHA256(String passwordSHA256) {
		this.passwordSHA256 = passwordSHA256;
	}

	public String getCodGender() {
		return codGender;
	}

	public void setCodGender(String codGender) {
		this.codGender = codGender;
	}

	public LocalDate getBornDate() {
		return bornDate;
	}

	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}

	public String getCodCustomer() {
		return codCustomer;
	}

	public void setCodCustomer(String codCustomer) {
		this.codCustomer = codCustomer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void save(Context ctx) {
		SharedPreferences sp = ctx.getSharedPreferences(Util.SHARED_PREFS , Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString("userdata_email",email);
		editor.putString("userdata_name",name);
		editor.commit();
	}

	public static UserDataShared carregar(Context ctx) {
		if (instance==null) {
			instance = new UserDataShared();
			SharedPreferences sp = ctx.getSharedPreferences(Util.SHARED_PREFS , Context.MODE_PRIVATE);
			instance.email = sp.getString("userdata_email","");
			instance.name = sp.getString("userdata_name", "");
			/*String aux = sp.getString("userdata_bornDate", "");
			if (aux.isEmpty()) {
				instance.bornDate = null;
			} else {
				instance.bornDate = LocalDate.parse(aux);
			}*/
		}
		return instance;
	}
}