import axios from "axios";
const DOCTOR_API_URL_BASE = "http://localhost:8090/api/doctor";
const DOCTOR_API_URL = "http://localhost:8090/api/doctor/getAll";
const DOCTOR_API_URL_DEL="http://localhost:8090/api/doctor/delete";


class DoctorService {

    getDoctors() {
        return axios.get(DOCTOR_API_URL);
      }


      getDoctorById(doctorid) {
        const url = `${DOCTOR_API_URL_BASE}/${doctorid}`;
        return axios.get(url);
      }
    
      updateDoctor(doctor) {
        // Construct the URL to the specific patient's endpoint
        
    
        // Send a PUT request to update the patient data
        return axios.put(DOCTOR_API_URL_BASE, doctor);
      }

      deleteDoctor(docid) {
        const url = `${DOCTOR_API_URL_DEL}/${docid}`;
        
        // Send a DELETE request to delete the patient by patientId
        return axios.delete(url);
      }
}


export default new DoctorService();