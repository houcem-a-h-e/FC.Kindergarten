export class Reclamations {
  id: number;
  subject: string;
  toComplain: ToComplain;
  ranking: Rankings;
  date: Date;
  description: string;
  answer: string;
  nbRec: number;
}
enum Rankings {
  very_important,
  important,
  normal,
  less_important,
  insignificant,
}
enum ToComplain {
  cleanliness,
  education,
  teachers,
  events,
  offres,
  director,
  Doctors,
  Buses,
}
