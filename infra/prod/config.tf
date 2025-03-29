terraform {
  required_providers {

    helm = {
      source  = "hashicorp/helm"
      version = "2.17.0"
    }

    aws = {
      source  = "hashicorp/aws"
      version = "5.93.0"
    }
  }

  backend "s3" {
    bucket = "nicholasmeyers-api-skoda-prd-terraform-state"
    key    = "terraform.tfstate"
    region = "eu-west-1"
  }
}

provider "helm" {
  kubernetes {
    config_path = "~/.kube/config"
  }
}
