package State;

public enum CityEnum {	
	BREST(DistrictEnum.BREST), BARANAVICHY(DistrictEnum.BARANAVICHY), PINSK(DistrictEnum.PINSK), KOBRYN(DistrictEnum.KOBRYN), 
	BYAROZA(DistrictEnum.BYAROZA), IVATSEVICHY(DistrictEnum.IVATSEVICHY), LUNINYETS(DistrictEnum.LUNINETS), PRUZHANY(DistrictEnum.PRUZHANY), 
	IVANAVA(DistrictEnum.IVANAVA), DRAHICHYN(DistrictEnum.DRAHICHYN), HANTSAVICHY(DistrictEnum.HANTSAVICHY), MIKASHEVICHY(DistrictEnum.LUNINETS),
	BYELAAZYORSK(DistrictEnum.BYAROZA), ZHABINKA(DistrictEnum.ZHABINKA), STOLIN(DistrictEnum.STOLIN), LYAKHAVICHY(DistrictEnum.LYAKHAVICHY), 
	MALARYTA(DistrictEnum.MALARYTA), KAMYANYETS(DistrictEnum.KAMENETS), DAVYD_HARADOK(DistrictEnum.STOLIN), VYSOKAYE(DistrictEnum.KAMENETS), 
	KOSAVA(DistrictEnum.IVATSEVICHY), TAMAŠOŬKA(DistrictEnum.BREST),
	
	VITEBSK(DistrictEnum.VITEBSK), ORSHA(DistrictEnum.ORSHA), NAVAPOLATSK(DistrictEnum.POLOTSK), POLOTSK(DistrictEnum.POLOTSK), 
	PASTAVY(DistrictEnum.PASTAVY), HLYBOKAYE(DistrictEnum.HLYBOKAYE), LEPEL(DistrictEnum.LEPIEL), NOVALUKOML(DistrictEnum.CHASHNIKI), 
	HARADOK(DistrictEnum.HARADOK), BARAN(DistrictEnum.ORSHA), TAŁAČYN(DistrictEnum.TALACHYN), BRASŁAŬ(DistrictEnum.BRASLAW), 
	ČAŠNIKI(DistrictEnum.CHASHNIKI), DUBROŬNA(DistrictEnum.DUBROŬNA), MIORY(DistrictEnum.MYORY), SYANNO(DistrictEnum.SYANNO), 
	BESHANKOVICHY(DistrictEnum.BESHANKOVICHY), VERKHNYADZVINSK(DistrictEnum.VERKHNYADZVINSK), DOKSHYTSY(DistrictEnum.DOKSHYTSY), 
	USHACHYU(DistrictEnum.USHACHY), DISNA(DistrictEnum.MYORY), SURAŽ(DistrictEnum.VITEBSK), 
	
	GOMEL(DistrictEnum.GOMEL), MAZYR(DistrictEnum.MAZYR), ZHLOBIN(DistrictEnum.ZHLOBIN), SVIETLAHORSK(DistrictEnum.SVIETLAHORSK), 
	RECHYTSA(DistrictEnum.RECHYTSA), KALINKAVICHY(DistrictEnum.KALINKAVICHY), RAHACHOW(DistrictEnum.RAHACHOW), DOBRUSH(DistrictEnum.DOBRUSH), 
	ZHYTKAVICHY(DistrictEnum.ZHYTKAVICHY), KHOYNIKI(DistrictEnum.KHOINIKI), PIETRYKAW(DistrictEnum.PIETRYKAW), YEL_SK(DistrictEnum.YEL_SK), 
	BUDA_KASHALYOVA(DistrictEnum.BUDA_KASHALYOVA), NAROULIA(DistrictEnum.NAROULIA), VIETKA(DistrictEnum.VIETKA), CHACHERSK(DistrictEnum.CHACHERSK), 
	VASILIEVICHY(DistrictEnum.RECHYTSA), BRAHIN(DistrictEnum.BRAHIN), TUROV(DistrictEnum.ZHYTKAVICHY),
	
	GRODNO(DistrictEnum.GRODNO), LIDA(DistrictEnum.LIDA), SLONIM(DistrictEnum.SLONIM), VAWKAVYSK(DistrictEnum.VAWKAVYSK), 
	SMARHOŃ(DistrictEnum.SMARHON), NAVAHRUDAK(DistrictEnum.NAVAHRUDAK), ASHMYANY(DistrictEnum.ASHMYANY), MASTY(DistrictEnum.MASTY), 
	SHCHUCHYN(DistrictEnum.SHCHUCHYN), ASTRAVYETS(DistrictEnum.ASTRAVYETS), SKIDZIEL(DistrictEnum.GRODNO), BYAROZAWKA(DistrictEnum.LIDA), 
	IWYE(DistrictEnum.IWYE), DZIATLAVA(DistrictEnum.DZYATLAVA), ZELVA(DistrictEnum.ZELVA), KRASNASELSKI(DistrictEnum.GRODNO), 
	KARELICHY(DistrictEnum.KARELICHY), SVISLACH(DistrictEnum.SVISLACH), VORANAVA(DistrictEnum.VORANAVA), VYALIKAYA_BYERASTAVITSA(DistrictEnum.BYERASTAVITSA), 
	ROS(DistrictEnum.GRODNO),
	
	BARYSAW(DistrictEnum.BARYSAW), SALIHORSK(DistrictEnum.SALIHORSK), MALADZYECHNA(DistrictEnum.MALADZYECHNA), SLUTSK(DistrictEnum.SLUTSK), 
	ZHODZINA(DistrictEnum.SMALYAVICHY), VILEYKA(DistrictEnum.VILEYKA), DZYARZHYNSK(DistrictEnum.DZYARZHYNSK), MARYINA_HORKA(DistrictEnum.PUCHAVIČY), 
	STOWBTSY(DistrictEnum.STOWBTSY), NYASVIZH(DistrictEnum.NESVIZH), SMALYAVICHY(DistrictEnum.SMALYAVICHY), ZASLAWYE(DistrictEnum.MINSK), 
	FANIPAL(DistrictEnum.DZYARZHYNSK), BERAZINO(DistrictEnum.MINSK), LYUBAN(DistrictEnum.LYUBAN), STARYYA_DAROHI(DistrictEnum.STARYYA_DAROHI), 
	VALOZHYN(DistrictEnum.VALOZHYN), LAHOYSK(DistrictEnum.LAHOYSK), KAPYL(DistrictEnum.KAPYL), KLETSK(DistrictEnum.KLETSK), 
	CHERVYEN(DistrictEnum.CHERVYEN), UZDA(DistrictEnum.UZDA), KRUPKI(DistrictEnum.KRUPKI), MYADZYEL(DistrictEnum.MYADZYEL), MINSK(DistrictEnum.MINSK),
	
	MOGILEV(DistrictEnum.MOGILEV), BABRUYSK(DistrictEnum.BABRUYSK), ASIPOVICHY(DistrictEnum.ASIPOVICHY), HORKI(DistrictEnum.HORKI), 
	KRYCHAW(DistrictEnum.KRYCHAW), BYKHAW(DistrictEnum.BYKHAW), KASTSYUKOVICHY(DistrictEnum.KASTSYUKOVICHY), KLIMAVICHY(DistrictEnum.KLIMAVICHY), 
	SHKLOW(DistrictEnum.SHKLOW), MSTSISLAW(DistrictEnum.MSTSISLAW), CHAVUSY(DistrictEnum.CHAVUSY), CHERYKAW(DistrictEnum.CHERYKAW), 
	SLAWHARAD(DistrictEnum.SLAWHARAD), KLICHAW(DistrictEnum.KLICHAW)
	;
	
	DistrictEnum districtEnum;

	private CityEnum(DistrictEnum districtEnum) {
		this.districtEnum = districtEnum;
	}

	public DistrictEnum getDistrictEnum() {
		return districtEnum;
	}

	public void setDistrictEnum(DistrictEnum districtEnum) {
		this.districtEnum = districtEnum;
	}		
}
