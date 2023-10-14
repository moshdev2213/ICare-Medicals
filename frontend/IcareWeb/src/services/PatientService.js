import axios from "axios";

const PATIENT_API_URL = "http://localhost:8083/patient";

class PatientService {
  getPatients() {
    return axios.get(PATIENT_API_URL);
  }

  getPatientById(patientId) {
    const url = `${PATIENT_API_URL}/${patientId}`;
    return axios.get(url);
  }

  updatePatient(patient) {
    // Construct the URL to the specific patient's endpoint
    // const url = `${PATIENT_API_URL}/${patient.id}`; // Replace 'id' with your patient identifier field name

    // Send a PUT request to update the patient data
    return axios.put(PATIENT_API_URL, patient);
  }

    deletePatient(patientId) {
    const url = `${PATIENT_API_URL}/${patientId}`;
    
    // Send a DELETE request to delete the patient by patientId
    return axios.delete(url);
  }



}

export default new PatientService();
