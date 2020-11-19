package com.example.android.practice;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private SongAdapter mAdapter;
    private TextView mTextView;
    private float textSize;

    /**
     * Lists names of all files in raw directory
     */
    public void listRaw() {
        int mCount, mResourceID;
        Field[] fields = R.raw.class.getFields();
        for (mCount = 0; mCount < fields.length; mCount++) {
            try {
                // get resource ids of file names
                mResourceID = fields[mCount].getInt(fields[mCount]);
            } catch (IllegalAccessException e) {
            }
            Log.i("Raw Asset: ", fields[mCount].getName());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list);

/*        bottomNavigation= (AHBottomNavigation) findViewById(R.id.myBottomNavigation_ID);

        bottomNavigation.setOnTabSelectedListener(this);
        this.createNavItems();*/

        /////////////////////////////////////////////
        // To cause the keyboard to close forcibly //
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        // @Link https://stackoverflow.com/questions/5105354/how-to-show-soft-keyboard-when-edittext-is-focused //
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        ArrayList<Song> songList = new ArrayList<>();

        songList.add(new Song("Adharam Madhuram", R.raw.adharam_madhuram_details, R.raw.adharam_madhuram_lyrics, R.raw.adharam_madhuram_translation));
        songList.add(new Song("Akordha Paramananda", R.raw.akordha_paramananda_details, R.raw.akordha_paramananda_lyrics, R.raw.akordha_paramananda_translation));
        songList.add(new Song("Amar Jivana", R.raw.amar_jivana_details, R.raw.amar_jivana_lyrics, R.raw.amar_jivana_translation));
        songList.add(new Song("Amar Nitai Mile Na", R.raw.amar_nitai_mile_na_details, R.raw.amar_nitai_mile_na_lyrics, R.raw.amar_nitai_mile_na_translation));
        songList.add(new Song("Ambudanjanendra Nila", R.raw.ambudanjanendra_nila_details, R.raw.ambudanjanendra_nila_lyrics, R.raw.ambudanjanendra_nila_translation));
        songList.add(new Song("Ami Jamuna Puline", R.raw.ami_jamuna_puline_details, R.raw.ami_jamuna_puline_lyrics, R.raw.ami_jamuna_puline_translation));
        songList.add(new Song("Ami To’ Durjana Ati Sada Duracar", R.raw.ami_to_durjana_ati_sada_duracar_details, R.raw.ami_to_durjana_ati_sada_duracar_lyrics, R.raw.ami_to_durjana_ati_sada_duracar_translation));
        songList.add(new Song("Anadi Karama Phale", R.raw.anadi_karama_phale_details, R.raw.anadi_karama_phale_lyrics, R.raw.anadi_karama_phale_translation));
        songList.add(new Song("Antara Mandire Jago Jago", R.raw.antara_mandire_jago_jago_details, R.raw.antara_mandire_jago_jago_lyrics, R.raw.antara_mandire_jago_jago_translation));
        songList.add(new Song("Ar Ke Bajabe Bamsi", R.raw.ar_ke_bajabe_bamsi_details, R.raw.ar_ke_bajabe_bamsi_lyrics, R.raw.ar_ke_bajabe_bamsi_translation));
        songList.add(new Song("Ar Keno Maya Jale", R.raw.ar_keno_maya_jale_details, R.raw.ar_keno_maya_jale_lyrics, R.raw.ar_keno_maya_jale_translation));
        songList.add(new Song("Ar Koto Kal", R.raw.ar_koto_kal_details, R.raw.ar_koto_kal_lyrics, R.raw.ar_koto_kal_translation));
        songList.add(new Song("Are Bhai Bhaja Mora Gauranga", R.raw.are_bhai_bhaja_mora_gauranga_details, R.raw.are_bhai_bhaja_mora_gauranga_lyrics, R.raw.are_bhai_bhaja_mora_gauranga_translation));
        songList.add(new Song("Asalo Katha Bolte", R.raw.asalo_katha_bolte_details, R.raw.asalo_katha_bolte_lyrics, R.raw.asalo_katha_bolte_translation));
        songList.add(new Song("Atma Nivedana Tuwa Pade", R.raw.atma_nivedana_tuwa_pade_details, R.raw.atma_nivedana_tuwa_pade_lyrics, R.raw.atma_nivedana_tuwa_pade_translation));
        songList.add(new Song("Avatara Sara Gora Avatar", R.raw.avatara_sara_gora_avatara_details, R.raw.avatara_sara_gora_avatara_lyrics, R.raw.avatara_sara_gora_avatara_translation));
        songList.add(new Song("Bhaja Bhakata Vatsala", R.raw.bhaja_bhakata_vatsala_details, R.raw.bhaja_bhakata_vatsala_lyrics, R.raw.bhaja_bhakata_vatsala_translation));
        songList.add(new Song("Bhaja Gauranga, Kaha Gauranga", R.raw.bhaja_gauranga_kaha_gauranga_details, R.raw.bhaja_gauranga_kaha_gauranga_lyrics, R.raw.bhaja_gauranga_kaha_gauranga_translation));
        songList.add(new Song("Bhaja Hu Re Mana", R.raw.bhaja_hu_re_mana_details, R.raw.bhaja_hu_re_mana_lyrics, R.raw.bhaja_hu_re_mana_translation));
        songList.add(new Song("Bhaja Re Bhaja Re Amar", R.raw.bhaja_re_bhaja_re_amar_details, R.raw.bhaja_re_bhaja_re_amar_lyrics, R.raw.bhaja_re_bhaja_re_amar_translation));
        songList.add(new Song("Bhale Gaura Gadadharer Arati", R.raw.bhale_gaura_gadadharer_arati_details, R.raw.bhale_gaura_gadadharer_arati_lyrics, R.raw.bhale_gaura_gadadharer_arati_translation));
        songList.add(new Song("Bhratur Antakasya Pattane", R.raw.bhratur_antakasya_pattane_details, R.raw.bhratur_antakasya_pattane_lyrics, R.raw.bhratur_antakasya_pattane_translation));
        songList.add(new Song("Bhuliya Tomare", R.raw.bhuliya_tomare_details, R.raw.bhuliya_tomare_lyrics, R.raw.bhuliya_tomare_translation));
        songList.add(new Song("Bolo Hari Bolo", R.raw.bolo_hari_bolo_details, R.raw.bolo_hari_bolo_lyrics, R.raw.bolo_hari_bolo_translation));
        songList.add(new Song("Boro Krpa Koile Krsna", R.raw.boro_krpa_koile_krsna_details, R.raw.boro_krpa_koile_krsna_lyrics, R.raw.boro_krpa_koile_krsna_translation));
        songList.add(new Song("Boro Sukher Khabor Gai", R.raw.boro_sukher_khabor_gai_details, R.raw.boro_sukher_khabor_gai_lyrics, R.raw.boro_sukher_khabor_gai_translation));
        songList.add(new Song("Carana Kamal", R.raw.carana_kamal_details, R.raw.carana_kamal_lyrics, R.raw.carana_kamal_translation));
        songList.add(new Song("Ceto Darpana Marjanam", R.raw.ceto_darpana_marjanam_details, R.raw.ceto_darpana_marjanam_lyrics, R.raw.ceto_darpana_marjanam_translation));
        songList.add(new Song("Devi Suresvari Bhagavati Gange", R.raw.devi_suresvari_bhagavati_gange_details, R.raw.devi_suresvari_bhagavati_gange_lyrics, R.raw.devi_suresvari_bhagavati_gange_translation));
        songList.add(new Song("Dhana Mor Nityananda", R.raw.dhana_mor_nityananda_details, R.raw.dhana_mor_nityananda_lyrics, R.raw.dhana_mor_nityananda_translation));
        songList.add(new Song("Dhule Dhule Gora Chanda", R.raw.dhule_dhule_gora_chanda_details, R.raw.dhule_dhule_gora_chanda_lyrics, R.raw.dhule_dhule_gora_chanda_translation));
        songList.add(new Song("Doyal Nitai Caitanya", R.raw.doyal_nitai_caitanya_details, R.raw.doyal_nitai_caitanya_lyrics, R.raw.doyal_nitai_caitanya_translation));
        songList.add(new Song("Duhkher Sagore", R.raw.duhkher_sagore_details, R.raw.duhkher_sagore_lyrics, R.raw.duhkher_sagore_translation));
        songList.add(new Song("Durlabha Manava Janma", R.raw.durlabha_manava_janma_details, R.raw.durlabha_manava_janma_lyrics, R.raw.durlabha_manava_janma_translation));
        songList.add(new Song("Dusta Mana", R.raw.dusta_mana_details, R.raw.dusta_mana_lyrics, R.raw.dusta_mana_translation));
        songList.add(new Song("Ei Baro Karuna Koro", R.raw.ei_baro_karuna_koro_details, R.raw.ei_baro_karuna_koro_lyrics, R.raw.ei_baro_karuna_koro_translation));
        songList.add(new Song("Ek Din Santipure", R.raw.ek_din_santipure_details, R.raw.ek_din_santipure_lyrics, R.raw.ek_din_santipure_translation));
        songList.add(new Song("Ekhona Bujhinu", R.raw.ekhona_bujhinu_details, R.raw.ekhona_bujhinu_lyrics, R.raw.ekhona_bujhinu_translation));
        songList.add(new Song("Emona Durmati", R.raw.emona_durmati_details, R.raw.emona_durmati_lyrics, R.raw.emona_durmati_translation));
        songList.add(new Song("Gangeya Campeya", R.raw.gangeya_campeya_details, R.raw.gangeya_campeya_lyrics, R.raw.gangeya_campeya_translation));
        songList.add(new Song("Gauranga Bolite Habe", R.raw.gauranga_bolite_habe_details, R.raw.gauranga_bolite_habe_lyrics, R.raw.gauranga_bolite_habe_translation));
        songList.add(new Song("Gauranga Karuna Koro", R.raw.gauranga_karuna_koro_details, R.raw.gauranga_karuna_koro_lyrics, R.raw.gauranga_karuna_koro_translation));
        songList.add(new Song("Gauranga Tumi More Doya Na Chadiho", R.raw.gauranga_tumi_more_doya_na_chadiho_details, R.raw.gauranga_tumi_more_doya_na_chadiho_lyrics, R.raw.gauranga_tumi_more_doya_na_chadiho_translation));
        songList.add(new Song("Gaurangera Duti Pada", R.raw.gaurangera_duti_pada_details, R.raw.gaurangera_duti_pada_lyrics, R.raw.gaurangera_duti_pada_translation));
        songList.add(new Song("Gay Gora Madhura Sware", R.raw.gay_gora_madhura_sware_details, R.raw.gay_gora_madhura_sware_lyrics, R.raw.gay_gora_madhura_sware_translation));
        songList.add(new Song("Gay Goracand Jiver Tore", R.raw.gay_goracand_jiver_tore_details, R.raw.gay_goracand_jiver_tore_lyrics, R.raw.gay_goracand_jiver_tore_translation));
        songList.add(new Song("Gopinath Amar Upaya", R.raw.gopinath_amar_upaya_details, R.raw.gopinath_amar_upaya_lyrics, R.raw.gopinath_amar_upaya_translation));
        songList.add(new Song("Gopinath Ghucao Samsara", R.raw.gopinath_ghucao_samsara_details, R.raw.gopinath_ghucao_samsara_lyrics, R.raw.gopinath_ghucao_samsara_translation));
        songList.add(new Song("Gopinath Mama Nivedana Suno", R.raw.gopinath_mama_nivedana_suno_details, R.raw.gopinath_mama_nivedana_suno_lyrics, R.raw.gopinath_mama_nivedana_suno_translation));
        songList.add(new Song("Gora Pahun", R.raw.gora_panhu_details, R.raw.gora_panhu_lyrics, R.raw.gora_panhu_translation));
        songList.add(new Song("Gurau Gosthe Gosthalayisu", R.raw.gurau_gosthe_gosthalayisu_details, R.raw.gurau_gosthe_gosthalayisu_lyrics, R.raw.gurau_gosthe_gosthalayisu_translation));
        songList.add(new Song("Gurudeva Krpa Bindu Diya", R.raw.gurudeva_krpa_bindu_diya_details, R.raw.gurudeva_krpa_bindu_diya_lyrics, R.raw.gurudeva_krpa_bindu_diya_translation));
        songList.add(new Song("Gurudeva! Boro Krpa Kori", R.raw.gurudeva_boro_krpa_kori_details, R.raw.gurudeva_boro_krpa_kori_lyrics, R.raw.gurudeva_boro_krpa_kori_translation));
        songList.add(new Song("Gurudeve Vraja Vane Vraja", R.raw.gurudeve_vraja_vane_vraja_details, R.raw.gurudeve_vraja_vane_vraja_lyrics, R.raw.gurudeve_vraja_vane_vraja_translation));
        songList.add(new Song("Hari Bolo Hari Bolo Hari Bolo Bhai Re", R.raw.hari_bolo_hari_bolo_hari_bolo_bhai_re_details, R.raw.hari_bolo_hari_bolo_hari_bolo_bhai_re_lyrics, R.raw.hari_bolo_hari_bolo_hari_bolo_bhai_re_translation));
        songList.add(new Song("Hari Haraye Namah Krsna Yadavaya", R.raw.hari_haraye_namah_krsna_yadavaya_namah_details, R.raw.hari_haraye_namah_krsna_yadavaya_namah_lyrics, R.raw.hari_haraye_namah_krsna_yadavaya_namah_translation));
        songList.add(new Song("Hari Hari Biphale Janama", R.raw.hari_hari_biphale_janama_details, R.raw.hari_hari_biphale_janama_lyrics, R.raw.hari_hari_biphale_janama_translation));
        songList.add(new Song("Hari Hari Kabe Mora Hobe Heno Dina", R.raw.hari_hari_kabe_mora_hobe_heno_dina_details, R.raw.hari_hari_kabe_mora_hobe_heno_dina_lyrics, R.raw.hari_hari_kabe_mora_hobe_heno_dina_translation));
        songList.add(new Song("Hari Hari Kabe More Hoibe Su-Dina", R.raw.hari_hari_kabe_more_hoibe_su_dina_details, R.raw.hari_hari_kabe_more_hoibe_su_dina_lyrics, R.raw.hari_hari_kabe_more_hoibe_su_dina_translation));
        songList.add(new Song("Hari He Doyal Mor", R.raw.hari_he_doyal_mor_details, R.raw.hari_he_doyal_mor_lyrics, R.raw.hari_he_doyal_mor_translation));
        songList.add(new Song("He Govinda He Gopal Kesava Madhava", R.raw.he_govinda_he_gopal_kesava_madhava_details, R.raw.he_govinda_he_gopal_kesava_madhava_lyrics, R.raw.he_govinda_he_gopal_kesava_madhava_translation));
        songList.add(new Song("Huhunkara Garjanadi Aho", R.raw.huhunkara_garjanadi_aho_details, R.raw.huhunkara_garjanadi_aho_lyrics, R.raw.huhunkara_garjanadi_aho_translation));
        songList.add(new Song("Isvara Parama Krsna", R.raw.isvara_parama_krsna_details, R.raw.isvara_parama_krsna_lyrics, R.raw.isvara_parama_krsna_translation));
        songList.add(new Song("Jaya Jaya Goracander Arotik", R.raw.jaya_jaya_goracander_arotik_details, R.raw.jaya_jaya_goracander_arotik_lyrics, R.raw.jaya_jaya_goracander_arotik_translation));
        songList.add(new Song("Jaya Jaya Jagannatha Sacira", R.raw.jaya_jaya_jagannatha_sacira_details, R.raw.jaya_jaya_jagannatha_sacira_lyrics, R.raw.jaya_jaya_jagannatha_sacira_translation));
        songList.add(new Song("Jaya Jaya Radha Krsna", R.raw.jaya_jaya_radha_krsna_details, R.raw.jaya_jaya_radha_krsna_lyrics, R.raw.jaya_jaya_radha_krsna_translation));
        songList.add(new Song("Jaya Jaya Sri Krsna Caitanya Nityananda", R.raw.jaya_jaya_sri_krsna_caitanya_nityananda_details, R.raw.jaya_jaya_sri_krsna_caitanya_nityananda_lyrics, R.raw.jaya_jaya_sri_krsna_caitanya_nityananda_translation));
        songList.add(new Song("Jaya Nrsimha Sri Nrsimha", R.raw.jaya_nrsimha_sri_nrsimha_details, R.raw.jaya_nrsimha_sri_nrsimha_lyrics, R.raw.jaya_nrsimha_sri_nrsimha_translation));
        songList.add(new Song("Jaya Radha Giri Vara Dhari", R.raw.jaya_radha_giri_vara_dhari_details, R.raw.jaya_radha_giri_vara_dhari_lyrics, R.raw.jaya_radha_giri_vara_dhari_translation));
        songList.add(new Song("Jaya Radha Madhava", R.raw.jaya_radha_madhava_details, R.raw.jaya_radha_madhava_lyrics, R.raw.jaya_radha_madhava_translation));
        songList.add(new Song("Jaya Radha Madhava Radha Madhava", R.raw.jaya_radha_madhava_radha_madhava_details, R.raw.jaya_radha_madhava_radha_madhava_lyrics, R.raw.jaya_radha_madhava_radha_madhava_translation));
        songList.add(new Song("Jaya Radhe Jaya Krsna Jaya Vrndavana", R.raw.jaya_radhe_jaya_krsna_jaya_vrndavana_details, R.raw.jaya_radhe_jaya_krsna_jaya_vrndavana_lyrics, R.raw.jaya_radhe_jaya_krsna_jaya_vrndavana_translation));
        songList.add(new Song("Jaya Radhe Jaya Radhe Radhe", R.raw.jaya_radhe_jaya_radhe_radhe_details, R.raw.jaya_radhe_jaya_radhe_radhe_lyrics, R.raw.jaya_radhe_jaya_radhe_radhe_translation));
        songList.add(new Song("Jayati Te 'Dhikam Janmana Vrajah (Gopi Gitam)", R.raw.jayati_te_dhikam_janmana_vrajah_details, R.raw.jayati_te_dhikam_janmana_vrajah_lyrics, R.raw.jayati_te_dhikam_janmana_vrajah_translation));
        songList.add(new Song("Je Anilo Prema Dhana", R.raw.je_anilo_prema_dhana_details, R.raw.je_anilo_prema_dhana_lyrics, R.raw.je_anilo_prema_dhana_translation));
        songList.add(new Song("Jiv Jago Jiv Jago", R.raw.jiv_jago_jiv_jago_details, R.raw.jiv_jago_jiv_jago_lyrics, R.raw.jiv_jago_jiv_jago_translation));
        songList.add(new Song("Kabe Gaura Vane", R.raw.kabe_gaura_vane_details, R.raw.kabe_gaura_vane_lyrics, R.raw.kabe_gaura_vane_translation));
        songList.add(new Song("Kabe Ha’be Bolo", R.raw.kabe_habe_bolo_details, R.raw.kabe_habe_bolo_lyrics, R.raw.kabe_habe_bolo_translation));
        songList.add(new Song("Kabe Habe Heno Dasa Mor", R.raw.kabe_habe_heno_dasa_mor_details, R.raw.kabe_habe_heno_dasa_mor_lyrics, R.raw.kabe_habe_heno_dasa_mor_translation));
        songList.add(new Song("Kabe Mui Vaisnava Cinibo", R.raw.kabe_mui_vaisnava_cinibo_details, R.raw.kabe_mui_vaisnava_cinibo_lyrics, R.raw.kabe_mui_vaisnava_cinibo_translation));
        songList.add(new Song("Kabe Sri Caitanya More Koribena Doya", R.raw.kabe_sri_caitanya_more_koribena_doya_details, R.raw.kabe_sri_caitanya_more_koribena_doya_lyrics, R.raw.kabe_sri_caitanya_more_koribena_doya_translation));
        songList.add(new Song("Kadacit Kalindi Tata Vipina", R.raw.kadacit_kalindi_tata_vipina_details, R.raw.kadacit_kalindi_tata_vipina_lyrics, R.raw.kadacit_kalindi_tata_vipina_translation));
        songList.add(new Song("Kali Kukkura Kadan", R.raw.kali_kukkura_kadan_details, R.raw.kali_kukkura_kadan_lyrics, R.raw.kali_kukkura_kadan_translation));
        songList.add(new Song("Keno Hare Krsna Nam", R.raw.keno_hare_krsna_nam_details, R.raw.keno_hare_krsna_nam_lyrics, R.raw.keno_hare_krsna_nam_translation));
        songList.add(new Song("Kesava Tuwa Jagata Vicitra", R.raw.kesava_tuwa_jagata_vicitra_details, R.raw.kesava_tuwa_jagata_vicitra_lyrics, R.raw.kesava_tuwa_jagata_vicitra_translation));
        songList.add(new Song("Ki Jani Ki Bale", R.raw.ki_jani_ki_bale_details, R.raw.ki_jani_ki_bale_lyrics, R.raw.ki_jani_ki_bale_translation));
        songList.add(new Song("Ki Rupe Paibo Seva", R.raw.ki_rupe_paibo_seva_details, R.raw.ki_rupe_paibo_seva_lyrics, R.raw.ki_rupe_paibo_seva_translation));
        songList.add(new Song("Krpa Koro Vaisnava Thakura", R.raw.krpa_koro_vaisnava_thakura_details, R.raw.krpa_koro_vaisnava_thakura_lyrics, R.raw.krpa_koro_vaisnava_thakura_translation));
        songList.add(new Song("Krsna Deva Bhavantam Vande", R.raw.krsna_deva_bhavantam_vande_details, R.raw.krsna_deva_bhavantam_vande_lyrics, R.raw.krsna_deva_bhavantam_vande_translation));
        songList.add(new Song("Krsna Hoite Caturmukha", R.raw.krsna_hoite_caturmukha_details, R.raw.krsna_hoite_caturmukha_lyrics, R.raw.krsna_hoite_caturmukha_translation));
        songList.add(new Song("Krsna Jinaka Nama Hai", R.raw.krsna_jinaka_nama_hai_details, R.raw.krsna_jinaka_nama_hai_lyrics, R.raw.krsna_jinaka_nama_hai_translation));
        songList.add(new Song("Krsna Krsna Krsna Krsna", R.raw.krsna_krsna_krsna_krsna_details, R.raw.krsna_krsna_krsna_krsna_lyrics, R.raw.krsna_krsna_krsna_krsna_translation));
        songList.add(new Song("Krsna Prema Mayi Radha", R.raw.krsna_prema_mayi_radha_details, R.raw.krsna_prema_mayi_radha_lyrics, R.raw.krsna_prema_mayi_radha_translation));
        songList.add(new Song("Krsna Tava Punya Habe Bhai", R.raw.krsna_tava_punya_habe_bhai_details, R.raw.krsna_tava_punya_habe_bhai_lyrics, R.raw.krsna_tava_punya_habe_bhai_translation));
        songList.add(new Song("Krsnotkirtana Gana Nartana", R.raw.krsnotkirtana_gana_nartana_parau_details, R.raw.krsnotkirtana_gana_nartana_parau_lyrics, R.raw.krsnotkirtana_gana_nartana_parau_translation));
        songList.add(new Song("Kunkumakta Kancanabja", R.raw.kunkumakta_kancanabja_details, R.raw.kunkumakta_kancanabja_lyrics, R.raw.kunkumakta_kancanabja_translation));
        songList.add(new Song("Kusumita Vrndavane Nacata Sikhi Gane", R.raw.kusumita_vrndavane_nacata_sikhi_gane_details, R.raw.kusumita_vrndavane_nacata_sikhi_gane_lyrics, R.raw.kusumita_vrndavane_nacata_sikhi_gane_translation));
        songList.add(new Song("Madana Mohana Tanu", R.raw.madana_mohana_tanu_details, R.raw.madana_mohana_tanu_lyrics, R.raw.madana_mohana_tanu_translation));
        songList.add(new Song("Madhuram Madhurebhyo ‘Pi", R.raw.madhuram_madhurebhyo_pi_details, R.raw.madhuram_madhurebhyo_pi_lyrics, R.raw.madhuram_madhurebhyo_pi_translation));
        songList.add(new Song("Maha Prasade Govinde", R.raw.maha_prasade_govinde_details, R.raw.maha_prasade_govinde_lyrics, R.raw.maha_prasade_govinde_translation));
        songList.add(new Song("Maine Ratana Lagai Radha Nama Ki", R.raw.maine_ratana_lagai_radha_nama_ki_details, R.raw.maine_ratana_lagai_radha_nama_ki_lyrics, R.raw.maine_ratana_lagai_radha_nama_ki_translation));
        songList.add(new Song("Mama Mana Mandire", R.raw.mama_mana_mandire_details, R.raw.mama_mana_mandire_lyrics, R.raw.mama_mana_mandire_translation));
        songList.add(new Song("Manasa Deho Geho Jo Kichu Mor", R.raw.manasa_deho_geho_jo_kichu_mor_details, R.raw.manasa_deho_geho_jo_kichu_mor_lyrics, R.raw.manasa_deho_geho_jo_kichu_mor_translation));
        songList.add(new Song("Mirar Prabhu Eso Giridhari", R.raw.mirar_prabhu_eso_giridhari_details, R.raw.mirar_prabhu_eso_giridhari_lyrics, R.raw.mirar_prabhu_eso_giridhari_translation));
        songList.add(new Song("Na Yoga Siddhir Na Mamastu", R.raw.na_yoga_siddhir_na_mamastu_details, R.raw.na_yoga_siddhir_na_mamastu_lyrics, R.raw.na_yoga_siddhir_na_mamastu_translation));
        songList.add(new Song("Nadiya Godrume Nityananda Mahajana", R.raw.nadiya_godrume_nityananda_mahajana_details, R.raw.nadiya_godrume_nityananda_mahajana_lyrics, R.raw.nadiya_godrume_nityananda_mahajana_translation));
        songList.add(new Song("Namamisvaram Saccidananda Rupam", R.raw.namamisvaram_saccidananda_rupam_details, R.raw.namamisvaram_saccidananda_rupam_lyrics, R.raw.namamisvaram_saccidananda_rupam_translation));
        songList.add(new Song("Namaste Narasimhaya", R.raw.namaste_narasimhaya_details, R.raw.namaste_narasimhaya_lyrics, R.raw.namaste_narasimhaya_translation));
        songList.add(new Song("Namo Namah Tulasi Krsna Preyasi", R.raw.namo_namah_tulasi_krsna_preyasi_details, R.raw.namo_namah_tulasi_krsna_preyasi_lyrics, R.raw.namo_namah_tulasi_krsna_preyasi_translation));
        songList.add(new Song("Namo Namah Tulasi Maharani", R.raw.namo_namah_tulasi_maharani_details, R.raw.namo_namah_tulasi_maharani_lyrics, R.raw.namo_namah_tulasi_maharani_translation));
        songList.add(new Song("Nanda Ke Ananda Bhaiyo", R.raw.nanda_ke_ananda_bhayo_details, R.raw.nanda_ke_ananda_bhayo_lyrics, R.raw.nanda_ke_ananda_bhayo_translation));
        songList.add(new Song("Narada Muni Bajay Vina", R.raw.narada_muni_bajay_vina_details, R.raw.narada_muni_bajay_vina_lyrics, R.raw.narada_muni_bajay_vina_translation));
        songList.add(new Song("Nava Gaura Varam", R.raw.nava_gaura_varam_details, R.raw.nava_gaura_varam_lyrics, R.raw.nava_gaura_varam_translation));
        songList.add(new Song("Nava Nirada Nindita", R.raw.nava_nirada_nindita_details, R.raw.nava_nirada_nindita_lyrics, R.raw.nava_nirada_nindita_translation));
        songList.add(new Song("Nija Karma Dose Phale", R.raw.nija_karma_dose_phale_details, R.raw.nija_karma_dose_phale_lyrics, R.raw.nija_karma_dose_phale_translation));
        songList.add(new Song("Nija Pati Bhuja", R.raw.nija_pati_bhuja_details, R.raw.nija_pati_bhuja_lyrics, R.raw.nija_pati_bhuja_translation));
        songList.add(new Song("Nitai Guna Mani", R.raw.nitai_guna_mani_details, R.raw.nitai_guna_mani_lyrics, R.raw.nitai_guna_mani_translation));
        songList.add(new Song("Nitai Nam Hate O Ke Jabire Bhai", R.raw.nitai_nam_hate_o_ke_jabire_bhai_details, R.raw.nitai_nam_hate_o_ke_jabire_bhai_lyrics, R.raw.nitai_nam_hate_o_ke_jabire_bhai_translation));
        songList.add(new Song("Nitai Pada Kamala", R.raw.nitai_pada_kamala_details, R.raw.nitai_pada_kamala_lyrics, R.raw.nitai_pada_kamala_translation));
        songList.add(new Song("Ohe Vaisnava Thakura", R.raw.ohe_vaisnava_thakura_details, R.raw.ohe_vaisnava_thakura_lyrics, R.raw.ohe_vaisnava_thakura_translation));
        songList.add(new Song("Ore Mana Bhalonahi Lage E Samsar", R.raw.ore_mana_bhalonahi_lage_e_samsar_details, R.raw.ore_mana_bhalonahi_lage_e_samsar_lyrics, R.raw.ore_mana_bhalonahi_lage_e_samsar_translation));
        songList.add(new Song("Ore Vrndavaner Nanda Dulal", R.raw.ore_vrndavaner_nanda_dulal_details, R.raw.ore_vrndavaner_nanda_dulal_lyrics, R.raw.ore_vrndavaner_nanda_dulal_translation));
        songList.add(new Song("Parama Karuna Pahu Dui Jana", R.raw.parama_karuna_pahu_dui_jana_details, R.raw.parama_karuna_pahu_dui_jana_lyrics, R.raw.parama_karuna_pahu_dui_jana_translation));
        songList.add(new Song("Prabhu Tava Pada Yuge", R.raw.prabhu_tava_pada_yuge_details, R.raw.prabhu_tava_pada_yuge_lyrics, R.raw.prabhu_tava_pada_yuge_translation));
        songList.add(new Song("Pralaya Payodhi Jale", R.raw.pralaya_payodhi_jale_details, R.raw.pralaya_payodhi_jale_lyrics, R.raw.pralaya_payodhi_jale_translation));
        songList.add(new Song("Pranam Tomai Ghana-Syam", R.raw.pranam_tomay_ghana_syam_details, R.raw.pranam_tomay_ghana_syam_lyrics, R.raw.pranam_tomay_ghana_syam_translation));
        songList.add(new Song("Prapance Poriya Agati", R.raw.prapance_poriya_agati_details, R.raw.prapance_poriya_agati_lyrics, R.raw.prapance_poriya_agati_translation));
        songList.add(new Song("Radha Krsna Bol Bol", R.raw.radha_krsna_bol_bol_details, R.raw.radha_krsna_bol_bol_lyrics, R.raw.radha_krsna_bol_bol_translation));
        songList.add(new Song("Radha Krsna Prana Mora", R.raw.radha_krsna_prana_mora_details, R.raw.radha_krsna_prana_mora_lyrics, R.raw.radha_krsna_prana_mora_translation));
        songList.add(new Song("Radha Kunda Tata Kunja Kutir", R.raw.radha_kunda_tata_kunja_kutir_details, R.raw.radha_kunda_tata_kunja_kutir_lyrics, R.raw.radha_kunda_tata_kunja_kutir_translation));
        songList.add(new Song("Radhe Jaya Jaya Madhava Dayite", R.raw.radhe_jaya_jaya_madhava_dayite_details, R.raw.radhe_jaya_jaya_madhava_dayite_lyrics, R.raw.radhe_jaya_jaya_madhava_dayite_translation));
        songList.add(new Song("Radhe Radhe Syama Sri Radhe", R.raw.radhe_radhe_syama_sri_radhe_details, R.raw.radhe_radhe_syama_sri_radhe_lyrics, R.raw.radhe_radhe_syama_sri_radhe_translation));
        songList.add(new Song("Raja Rani Mira", R.raw.raja_rani_mira_details, R.raw.raja_rani_mira_lyrics, R.raw.raja_rani_mira_translation));
        songList.add(new Song("Sakhe Kalaya Gauram Udaram", R.raw.sakhe_kalaya_gauram_udaram_details, R.raw.sakhe_kalaya_gauram_udaram_lyrics, R.raw.sakhe_kalaya_gauram_udaram_translation));
        songList.add(new Song("Samsara Davanala Lidha Loka", R.raw.samsara_davanala_lidha_loka_details, R.raw.samsara_davanala_lidha_loka_lyrics, R.raw.samsara_davanala_lidha_loka_translation));
        songList.add(new Song("Sarira Avidya Jala", R.raw.sarira_avidya_jala_details, R.raw.sarira_avidya_jala_lyrics, R.raw.sarira_avidya_jala_translation));
        songList.add(new Song("Sarvasva Tomar Carane", R.raw.sarvasva_tomar_carane_details, R.raw.sarvasva_tomar_carane_lyrics, R.raw.sarvasva_tomar_carane_translation));
        songList.add(new Song("Sri Guru Carana Padma", R.raw.sri_guru_carana_padma_details, R.raw.sri_guru_carana_padma_lyrics, R.raw.sri_guru_carana_padma_translation));
        songList.add(new Song("Sri Guru Pranama", R.raw.sri_guru_pranama_details, R.raw.sri_guru_pranama_lyrics, R.raw.sri_guru_pranama_translation));
        songList.add(new Song("Sri Hari Vasare Hari Kirtana Vidhana", R.raw.sri_hari_vasare_hari_kirtana_vidhana_details, R.raw.sri_hari_vasare_hari_kirtana_vidhana_lyrics, R.raw.sri_hari_vasare_hari_kirtana_vidhana_translation));
        songList.add(new Song("Sri Krsna Caitanya Prabhu", R.raw.sri_krsna_caitanya_prabhu_details, R.raw.sri_krsna_caitanya_prabhu_lyrics, R.raw.sri_krsna_caitanya_prabhu_translation));
        songList.add(new Song("Sri Krsna Caitanya Prabhu Jive Doya Kori", R.raw.sri_krsna_caitanya_prabhu_jive_doya_kori_details, R.raw.sri_krsna_caitanya_prabhu_jive_doya_kori_lyrics, R.raw.sri_krsna_caitanya_prabhu_jive_doya_kori_translation));
        songList.add(new Song("Sri Krsna Sankirtane Jadi Manasa Tohar", R.raw.sri_krsna_sankirtane_jadi_manasa_tohar_details, R.raw.sri_krsna_sankirtane_jadi_manasa_tohar_lyrics, R.raw.sri_krsna_sankirtane_jadi_manasa_tohar_translation));
        songList.add(new Song("Sri Rupa Manjari Pada Sei Mora Sampada", R.raw.sri_rupa_manjari_pada_sei_mora_sampada_details, R.raw.sri_rupa_manjari_pada_sei_mora_sampada_lyrics, R.raw.sri_rupa_manjari_pada_sei_mora_sampada_translation));
        songList.add(new Song("Srita Kamala", R.raw.srita_kamala_details, R.raw.srita_kamala_lyrics, R.raw.srita_kamala_translation));
        songList.add(new Song("Suddha Bhakata Carana Renu", R.raw.suddha_bhakata_carana_renu_details, R.raw.suddha_bhakata_carana_renu_lyrics, R.raw.suddha_bhakata_carana_renu_translation));
        songList.add(new Song("Sujanarvuda Radhita Pada", R.raw.sujanarvuda_radhita_pada_details, R.raw.sujanarvuda_radhita_pada_lyrics, R.raw.sujanarvuda_radhita_pada_translation));
        songList.add(new Song("Sundara Bala Saci Dulala", R.raw.sundara_bala_saci_dulala_details, R.raw.sundara_bala_saci_dulala_lyrics, R.raw.sundara_bala_saci_dulala_translation));
        songList.add(new Song("Sundara Kuṇḍala Naina", R.raw.sundara_kundala_naina_details, R.raw.sundara_kundala_naina_lyrics, R.raw.sundara_kundala_naina_translation));
        songList.add(new Song("Sundara Mora Mana Kisora", R.raw.sundara_mora_mana_kisora_details, R.raw.sundara_mora_mana_kisora_lyrics, R.raw.sundara_mora_mana_kisora_translation));
        songList.add(new Song("Suniyachi Sadhu Mukhe Bole", R.raw.suniyachi_sadhu_mukhe_bole_details, R.raw.suniyachi_sadhu_mukhe_bole_lyrics, R.raw.suniyachi_sadhu_mukhe_bole_translation));
        songList.add(new Song("Tatala Saikate", R.raw.tatala_saikate_details, R.raw.tatala_saikate_lyrics, R.raw.tatala_saikate_translation));
        songList.add(new Song("Thakura Vaisnava Gana", R.raw.thakura_vaisnava_gana_details, R.raw.thakura_vaisnava_gana_lyrics, R.raw.thakura_vaisnava_gana_translation));
        songList.add(new Song("Thakura Vaisnava Pada", R.raw.thakura_vaisnava_pada_details, R.raw.thakura_vaisnava_pada_lyrics, R.raw.thakura_vaisnava_pada_translation));
        songList.add(new Song("The Ten Offenses to the Holy Name", R.raw.the_ten_offenses_to_the_holy_name_details, R.raw.the_ten_offenses_to_the_holy_name_lyrics, R.raw.the_ten_offenses_to_the_holy_name_translation));
        songList.add(new Song("Tumi Sarveswareswara Vrajendra Kumar", R.raw.tumi_sarveswareswara_vrajendra_kumar_details, R.raw.tumi_sarveswareswara_vrajendra_kumar_lyrics, R.raw.tumi_sarveswareswara_vrajendra_kumar_translation));
        songList.add(new Song("Udilo Aruna", R.raw.udilo_aruna_details, R.raw.udilo_aruna_lyrics, R.raw.udilo_aruna_translation));
        songList.add(new Song("Ugra Viram Mahavisnu", R.raw.ugram_viram_mahavishnu_details, R.raw.ugram_viram_mahavishnu_lyrics, R.raw.ugram_viram_mahavishnu_translation));
        songList.add(new Song("Ujjvala Varana", R.raw.ujjvala_varana_details, R.raw.ujjvala_varana_lyrics, R.raw.ujjvala_varana_translation));
        songList.add(new Song("Vamsi Dhari Krsna Murari", R.raw.vamsi_dhari_krsna_murari_details, R.raw.vamsi_dhari_krsna_murari_lyrics, R.raw.vamsi_dhari_krsna_murari_translation));
        songList.add(new Song("Vande Krsna Nanda Kumara", R.raw.vande_krsna_nanda_kumara_details, R.raw.vande_krsna_nanda_kumara_lyrics, R.raw.vande_krsna_nanda_kumara_translation));
        songList.add(new Song("Vibhavari Sesa", R.raw.vibhavari_sesa_details, R.raw.vibhavari_sesa_lyrics, R.raw.vibhavari_sesa_translation));
        songList.add(new Song("Vidyara Vilase", R.raw.vidyara_vilase_details, R.raw.vidyara_vilase_lyrics, R.raw.vidyara_vilase_translation));
        songList.add(new Song("Vraje Prasiddham Navanita", R.raw.vraje_prasiddham_navanita_details, R.raw.vraje_prasiddham_navanita_lyrics, R.raw.vraje_prasiddham_navanita_translation));
        songList.add(new Song("Vrndavana Ramya Sthana", R.raw.vrndavana_ramya_sthana_details, R.raw.vrndavana_ramya_sthana_lyrics, R.raw.vrndavana_ramya_sthana_translation));
        songList.add(new Song("Vrndavana Vasi Jata Vaisnavera Gana", R.raw.vrndavana_vasi_jata_vaisnavera_gana_details, R.raw.vrndavana_vasi_jata_vaisnavera_gana_lyrics, R.raw.vrndavana_vasi_jata_vaisnavera_gana_translation));
        songList.add(new Song("Yadi Gaura Na Hoito", R.raw.yadi_gaura_na_hoito_details, R.raw.yadi_gaura_na_hoito_lyrics, R.raw.yadi_gaura_na_hoito_translation));
        songList.add(new Song("Yadi Te Hari Pada Saroja Sudha", R.raw.yadi_te_hari_pada_saroja_sudha_details, R.raw.yadi_te_hari_pada_saroja_sudha_lyrics, R.raw.yadi_te_hari_pada_saroja_sudha_translation));

        mAdapter = new SongAdapter(this, songList);

        mListView = (ListView) findViewById(R.id.songs_list);
        mListView.setAdapter(mAdapter);


        /**
         * Opens LyricsActivity on item clicking
         */
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song itemIdAtPosition = (Song) parent.getAdapter().getItem(position);
                Intent lyricsIntent = new Intent(MainActivity.this, LyricsActivity.class);

                // Sending song title to lyrics activity
                lyricsIntent.putExtra("title", itemIdAtPosition.getmName());

                // Sending song details to lyrics activity
                lyricsIntent.putExtra("detailsResourceId", itemIdAtPosition.getmDetailsResourceId());

                // Sending song lyrics to lyrics activity
                lyricsIntent.putExtra("lyricsResourceId", itemIdAtPosition.getmLyricsResourceId());

                // Sending song translation to lyrics activity
                lyricsIntent.putExtra("translationResourceId", itemIdAtPosition.getmTranslationResourceId());

                if (lyricsIntent.resolveActivity(getPackageManager()) != null) {
                    // Starting lyrics activity
                    startActivity(lyricsIntent);
                }
            }
        });
    }

    /**
     * For filtering list items using search view
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setSubmitButtonEnabled(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String constraint) {
                mAdapter.getFilter().filter(constraint);
                return false;
            }
        });

        return true;
    }

}