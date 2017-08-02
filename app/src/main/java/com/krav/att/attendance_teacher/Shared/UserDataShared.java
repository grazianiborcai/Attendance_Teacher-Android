package com.krav.att.attendance_teacher.Shared;

import android.content.Context;
import android.content.SharedPreferences;

import com.krav.att.attendance_teacher.Util.Util;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

public class UserDataShared {

	private Long peopleID, enrollmentNumber;
    private Integer enrTypeID, gradeID, genderID, whereID, lookID;
    private String countryID, name, email, celphone, phone, address1, address2, postalCode, bloodType, allergy, allergyDesc, whereOther, lookingOther, password, oAuth, userAgent, regionID, birthDateS, gradeDateS, nextGradeExamS;
	private LocalDate birthDate, gradeDate, nextGradeExam;
    private LocalDateTime oAuthDate;

	private static UserDataShared instance;

	private UserDataShared() {}

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

    public Long getPeopleID() {
        return peopleID;
    }

    public void setPeopleID(Long peopleID) {
        this.peopleID = peopleID;
    }

    public Long getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(Long enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public Integer getEnrTypeID() {
        return enrTypeID;
    }

    public void setEnrTypeID(Integer enrTypeID) {
        this.enrTypeID = enrTypeID;
    }

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public Integer getGenderID() {
        return genderID;
    }

    public void setGenderID(Integer genderID) {
        this.genderID = genderID;
    }

    public Integer getWhereID() {
        return whereID;
    }

    public void setWhereID(Integer whereID) {
        this.whereID = whereID;
    }

    public Integer getLookID() {
        return lookID;
    }

    public void setLookID(Integer lookID) {
        this.lookID = lookID;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getCelphone() {
        return celphone;
    }

    public void setCelphone(String celphone) {
        this.celphone = celphone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getAllergyDesc() {
        return allergyDesc;
    }

    public void setAllergyDesc(String allergyDesc) {
        this.allergyDesc = allergyDesc;
    }

    public String getWhereOther() {
        return whereOther;
    }

    public void setWhereOther(String whereOther) {
        this.whereOther = whereOther;
    }

    public String getLookingOther() {
        return lookingOther;
    }

    public void setLookingOther(String lookingOther) {
        this.lookingOther = lookingOther;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getoAuth() {
        return oAuth;
    }

    public void setoAuth(String oAuth) {
        this.oAuth = oAuth;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public String getBirthDateS() {
        return birthDateS;
    }

    public void setBirthDateS(String birthDateS) {
        this.birthDateS = birthDateS;
    }

    public String getGradeDateS() {
        return gradeDateS;
    }

    public void setGradeDateS(String gradeDateS) {
        this.gradeDateS = gradeDateS;
    }

    public String getNextGradeExamS() {
        return nextGradeExamS;
    }

    public void setNextGradeExamS(String nextGradeExamS) {
        this.nextGradeExamS = nextGradeExamS;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getGradeDate() {
        return gradeDate;
    }

    public void setGradeDate(LocalDate gradeDate) {
        this.gradeDate = gradeDate;
    }

    public LocalDate getNextGradeExam() {
        return nextGradeExam;
    }

    public void setNextGradeExam(LocalDate nextGradeExam) {
        this.nextGradeExam = nextGradeExam;
    }

    public LocalDateTime getoAuthDate() {
        return oAuthDate;
    }

    public void setoAuthDate(LocalDateTime oAuthDate) {
        this.oAuthDate = oAuthDate;
    }

    public static UserDataShared getInstance() {
        return instance;
    }

    public static void setInstance(UserDataShared instance) {
        UserDataShared.instance = instance;
    }

    public void save(Context ctx) {
		SharedPreferences sp = ctx.getSharedPreferences(Util.SHARED_PREFS , Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
        editor.putLong("userdata_peopleID", peopleID);
        editor.putString("userdata_countryID", countryID);
        editor.putString("userdata_name", name);
        editor.putString("userdata_birthDate", birthDate.toString());
        editor.putLong("userdata_enrollmentNumber", enrollmentNumber);
        editor.putString("userdata_gradeDate", gradeDate.toString());
        editor.putString("userdata_email", email);
        editor.putString("userdata_celphone", celphone);
        editor.putString("userdata_phone", phone);
        editor.putString("userdata_address1", address1);
        editor.putString("userdata_address2", address2);
        editor.putString("userdata_postalCode", postalCode);
        editor.putString("userdata_bloodType", bloodType);
        editor.putString("userdata_allergy", allergy);
        editor.putString("userdata_allergyDesc", allergyDesc);
        editor.putString("userdata_nextGradeExam", nextGradeExam.toString());
        editor.putString("userdata_whereOther", whereOther);
        editor.putString("userdata_lookingOther", lookingOther);
        editor.putString("userdata_password", password);
        editor.putInt("userdata_enrTypeID", enrTypeID);
        editor.putString("userdata_oAuth", oAuth);
        editor.putString("userdata_oAuthDate", oAuthDate.toString());
        editor.putString("userdata_userAgent", userAgent);
        editor.putString("userdata_regionID", regionID);
        editor.putInt("userdata_gradeID", gradeID);
        editor.putString("userdata_birthDateS", birthDateS);
        editor.putString("userdata_gradeDateS", gradeDateS);
        editor.putString("userdata_nextGradeExamS", nextGradeExamS);
        editor.putInt("userdata_genderID", genderID);
        editor.putInt("userdata_whereID", whereID);
        editor.putInt("userdata_lookID", lookID);
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
            instance.peopleID = sp.getLong("userdata_peopleID", 0);
            instance.countryID = sp.getString("userdata_countryID", countryID);
            instance.name = sp.getString("userdata_name", name);
            instance.birthDate = sp.getString("userdata_birthDate", birthDate.toString());
            instance.enrollmentNumber = sp.getLong("userdata_enrollmentNumber", enrollmentNumber);
            instance.gradeDate = sp.getString("userdata_gradeDate", gradeDate.toString());
            instance.email = sp.getString("userdata_email", email);
            instance.celphone = sp.getString("userdata_celphone", celphone);
            instance.phone = sp.getString("userdata_phone", phone);
            instance.address1 = sp.getString("userdata_address1", address1);
            instance.address2 = sp.getString("userdata_address2", address2);
            instance.postalCode = sp.getString("userdata_postalCode", postalCode);
            instance.bloodType = sp.getString("userdata_bloodType", bloodType);
            instance.allergy = sp.getString("userdata_allergy", allergy);
            instance.allergyDesc = sp.getString("userdata_allergyDesc", allergyDesc);
            instance.nextGradeExam = sp.getString("userdata_nextGradeExam", nextGradeExam.toString());
            instance.whereOther = sp.getString("userdata_whereOther", whereOther);
            instance.lookingOther = sp.getString("userdata_lookingOther", lookingOther);
            instance.password = sp.getString("userdata_password", password);
            instance.enrTypeID = sp.getInt("userdata_enrTypeID", enrTypeID);
            instance.oAuth = sp.getString("userdata_oAuth", oAuth);
            instance.oAuthDate = sp.getString("userdata_oAuthDate", oAuthDate.toString());
            instance.userAgent = sp.getString("userdata_userAgent", userAgent);
            instance.regionID = sp.getString("userdata_regionID", regionID);
            instance.gradeID = sp.getInt("userdata_gradeID", gradeID);
            instance.birthDateS = sp.getString("userdata_birthDateS", birthDateS);
            instance.gradeDateS = sp.getString("userdata_gradeDateS", gradeDateS);
            instance.nextGradeExamS = sp.getString("userdata_nextGradeExamS", nextGradeExamS);
            instance.genderID = sp.getInt("userdata_genderID", genderID);
            instance.whereID = sp.getInt("userdata_whereID", whereID);
            instance.lookID = sp.getInt("userdata_lookID", lookID);
		}
		return instance;
	}
}