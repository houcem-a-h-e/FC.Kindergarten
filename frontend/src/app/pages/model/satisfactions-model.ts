import {Parent} from './parent';

export class SatisfactionsModel {
  'id': number;
  'date': Date;
  'satisfactionOfYourChild': Satisfactions;
  'sysOfEducation': Satisfactions;
  'satisEvent': Satisfactions;
  'satisOffer': Satisfactions;
  'statisTeamsOfFc': Satisfactions;
  'statisambiance': Satisfactions;
  'statisCommunicationOnFc': Satisfactions;
  'noteFc': String;
  'statisCommunationOnFc': Satisfactions;
}
enum Satisfactions {
  so_bad,
  bad,
  normal,
  good,
  very_good,
  excellent,
}
