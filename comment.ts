import { Parent } from './parent';
import { Post } from './post';

export class Comment {
  id_comment: number;
  textComment: string;
  date_comment: Date = new Date();
  parent: Parent;
  post: Post;
}
