package com.project.Icare.EmailTemps;

import com.project.Icare.Collection.Appointment;

public class SMSAppointment {
	
	public static String msg(Appointment appointment) { 
		String ms01 = "Dear Mr. " + appointment.getPatName() + ",\\n" +
		        "This is to confirm that your appointment with Reference Number: " + appointment.getReference() + " For Dr. " + appointment.getDocName() + " has been successfully scheduled for The Date " + appointment.getDate() + "," + appointment.getTime() + " at " + appointment.getVenue() + ".\\n" +
		        "Please make sure to arrive on time for your appointment. If you need to reschedule or have any questions, please contact us at 0371267865.\\n\\n" +
		        "Thank you for choosing our services. We look forward to serving you.\\n" +
		        "Best regards,\\n" +
		        "ICare Medicals Pvt.Ltd\\n";

		
		
		
		return ms01;
	}
}
