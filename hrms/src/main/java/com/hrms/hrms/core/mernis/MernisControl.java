package com.hrms.hrms.core.mernis;

import java.rmi.RemoteException;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisControl {
	public static boolean checkMernis(long TCKimlikNo, String ad, String soyad,int dogumYili) throws RemoteException {
		KPSPublicSoapProxy kpsPublic = new KPSPublicSoapProxy();
		return kpsPublic.TCKimlikNoDogrula(TCKimlikNo, ad, soyad, dogumYili);
	}
}
