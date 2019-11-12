# appointment-web-app
simple Appointment web application between doctors and patients.

# notes the application 
 * the application has 3 services and configuration service that hold all the configuration for those services, this            configurations exist on this branch "https://github.com/tawfikelbadry/appointments-git-config-repo" you can create another    repository with the configuration you want and put the url in the config server service in application.properties for the    value of this attribute "spring.cloud.config.server.git.uri".
 
# application services :
     * gateway micro service : runs on port 8005
     * doctor micro service : runs on port 8000  (holds the parts )
     * patient micro service : runs on port 8001
     * config server : runs on port 8888

# steps 
    1.create a database called `appointments-app-db`
    2.prepare your enviroment if you work locally or on a production :
      * clone the git repository
      * setup java ide (sts, intelij,etc)
      * import the 4 services in the ide and download dependencies.
    3. run config server
    4. run the 3 services.
    5. you can now work with the rest apis.

# endpoints ( default is GET )
    * localhost:8005/api/users/register-doctor           //register a doctor (POST)
    * localhost:8005/api/users/register-patient          // register a patient (POST)       
    * localhost:8005/api/users/is-authenticate
    * localhost:8000/api/appointments                    // return all appointments
    * localhost:8000/api/appointments/available          // return all available appointments
    * localhost:8000/api/appointments/{appointementId}/is-available     // check if appointment with id=? is available  
    * localhost:8000/api/appointments/{appointmentId}/mark-unavailable  //mark appointment as unavilable  (POST)
    * localhost:8000/api/doctors                         // return all doctors
    * localhost:8000/api/doctors                         //save doctor  (POST)
    * localhost:8001/api/patient-appointements/{patientId}/appointment/{appointementId}        //reserve appointment to             patient (POST)
    * localhost:8001/api/patients/save                  // save patient (POST)          

# TODO  ( I will complete the documentation tommorow )
    * complete the documentation ( the database design , the code architchre , the system design)   (tommorow)
    * adding the services as docker images and the docs for how to run it from docker               (week end)
    * add the security on the gateway service that controls all security for the system             (week end)
    * add some message queue for handling the work between services                                 (week end)
    * add the validation for all the api's                                                          (week end)
